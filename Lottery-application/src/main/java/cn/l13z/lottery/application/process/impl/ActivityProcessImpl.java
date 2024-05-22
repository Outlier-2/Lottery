package cn.l13z.lottery.application.process.impl;

import cn.l13z.lottery.application.mq.producer.SendLotteryInvoice;
import cn.l13z.lottery.application.process.IActivityProcess;
import cn.l13z.lottery.application.process.req.DrawProcessReq;
import cn.l13z.lottery.application.process.res.DrawProcessResult;
import cn.l13z.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.common.Constants.Ids;
import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.res.PartakeResult;
import cn.l13z.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.l13z.lottery.domain.activity.model.vo.InvoiceVO;
import cn.l13z.lottery.domain.activity.service.partake.IActivityPartake;
import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.model.res.EngineResult;
import cn.l13z.lottery.domain.rule.service.engine.IEngineFilter;
import cn.l13z.lottery.domain.strategy.model.req.DrawReq;
import cn.l13z.lottery.domain.strategy.model.res.DrawResult;
import cn.l13z.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.l13z.lottery.domain.strategy.service.draw.IDrawExec;
import cn.l13z.lottery.domain.support.ids.IIdGenerator;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * ClassName: ActivityProcessImpl.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 03:26 <br> Description: 活动流程实现 <br>
 * <p>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 活动流程实现 <br>
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDrawExec drawExec;

    @Resource(name = "ruleEngineHandle")
    private IEngineFilter engineFilter;

    @Resource
    private Map<Ids, IIdGenerator> idGeneratorMap;

    @Resource
    private SendLotteryInvoice sendLotteryInvoice;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {
        // 1. 领取活动
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getuId(), req.getActivityId()));
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }
        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2. 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq(req.getuId(), strategyId, String.valueOf(takeId)));
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(Constants.ResponseCode.LOSING_DRAW.getCode(),
                Constants.ResponseCode.LOSING_DRAW.getInfo());
        }
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();

        // 3. 结果落库
        DrawOrderVO drawOrderVo = buildDrawOrderVO(req, strategyId, takeId, drawAwardInfo);
        Result recordResult = activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardInfo));
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(recordResult.getCode())) {
            return new DrawProcessResult(recordResult.getCode(), recordResult.getInfo());
        }

        // 4. 发送MQ，触发发奖流程
        InvoiceVO invoiceVO = buildInvoiceVO(drawOrderVo);
        ListenableFuture<SendResult<String, Object>> future = sendLotteryInvoice.sendLotteryInvoice(
            invoiceVO);
        future.addCallback(
            new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    // 4.1 MQ 消息发送完成，更新数据库表 user_strategy_export.mq_state = 1
                    activityPartake.updateInvoiceMqState(invoiceVO.getuId(), Long.valueOf(invoiceVO.getOrderId()),
                        Constants.MQState.COMPLETE.getCode());
                }

                @Override
                public void onFailure(Throwable ex) {
                    // 4.2 MQ 消息发送失败，更新数据库表 user_strategy_export.mq_state = 2 【等待定时任务扫码补偿MQ消息】
                    activityPartake.updateInvoiceMqState(invoiceVO.getuId(), Long.valueOf(invoiceVO.getOrderId()),
                        Constants.MQState.FAIL.getCode());
                }
            }
        );
        // 5. 返回结果
        return new DrawProcessResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(),
            drawAwardInfo);

    }

    @Override
    public RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req) {
        // 1. 量化决策
        EngineResult engineResult = engineFilter.process(req);

        if (!engineResult.isSuccess()) {
            return new RuleQuantificationCrowdResult(Constants.ResponseCode.RULE_ERR.getCode(),
                Constants.ResponseCode.RULE_ERR.getInfo());
        }

        // 2. 封装结果
        RuleQuantificationCrowdResult ruleQuantificationCrowdResult = new RuleQuantificationCrowdResult(
            Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        ruleQuantificationCrowdResult.setActivityId(Long.valueOf(engineResult.getNodeValue()));

        return ruleQuantificationCrowdResult;
    }

    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId,
        DrawAwardInfo drawAwardInfo) {
        long orderId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setuId(req.getuId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardInfo.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardInfo.getGrantType());
        drawOrderVO.setGrantDate(drawAwardInfo.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardInfo.getAwardId());
        drawOrderVO.setAwardType(drawAwardInfo.getAwardType());
        drawOrderVO.setAwardName(drawAwardInfo.getAwardName());
        drawOrderVO.setAwardContent(drawAwardInfo.getAwardContent());
        return drawOrderVO;
    }

    private InvoiceVO buildInvoiceVO(DrawOrderVO drawOrderVO) {
        InvoiceVO invoiceVO = new InvoiceVO();
        invoiceVO.setuId(drawOrderVO.getuId());
        invoiceVO.setOrderId(drawOrderVO.getOrderId());
        invoiceVO.setAwardId(drawOrderVO.getAwardId());
        invoiceVO.setAwardType(drawOrderVO.getAwardType());
        invoiceVO.setAwardName(drawOrderVO.getAwardName());
        invoiceVO.setAwardContent(drawOrderVO.getAwardContent());
        invoiceVO.setShippingAddress(null);
        invoiceVO.setExtInfo(null);
        return invoiceVO;
    }

}
