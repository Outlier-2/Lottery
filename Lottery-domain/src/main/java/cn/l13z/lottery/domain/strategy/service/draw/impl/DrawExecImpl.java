package cn.l13z.lottery.domain.strategy.service.draw.impl;

import cn.l13z.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.l13z.lottery.domain.strategy.model.req.DrawReq;
import cn.l13z.lottery.domain.strategy.model.res.DrawRes;
import cn.l13z.lottery.domain.strategy.repository.IStrategyRepository;
import cn.l13z.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.l13z.lottery.domain.strategy.service.draw.DrawBase;
import cn.l13z.lottery.domain.strategy.service.draw.IDrawExec;
import cn.l13z.lottery.infrastructure.po.Award;
import cn.l13z.lottery.infrastructure.po.Strategy;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ClassName: DrawExecImpl.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 06:01 <br> Description: 抽奖实现类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 抽奖实现类 <br>
 */
@Service
public class DrawExecImpl extends DrawBase implements IDrawExec {

    private final Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawRes doDrawExec(DrawReq req) {
        logger.info("执行策略抽奖开始，strategyId：{}", req.getStrategyId());

        // 获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验和初始化数据
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略方式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", req.getUId(), awardId, award.getAwardName());

        // 封装结果
        return new DrawRes(req.getUId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
