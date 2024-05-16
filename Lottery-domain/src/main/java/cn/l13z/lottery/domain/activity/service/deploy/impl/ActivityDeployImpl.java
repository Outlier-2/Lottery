package cn.l13z.lottery.domain.activity.service.deploy.impl;

import cn.l13z.lottery.domain.activity.model.aggregation.ActivityConfigRich;
import cn.l13z.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.l13z.lottery.domain.activity.model.vo.ActivityVO;
import cn.l13z.lottery.domain.activity.model.vo.AwardVO;
import cn.l13z.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.l13z.lottery.domain.activity.model.vo.StrategyVO;
import cn.l13z.lottery.domain.activity.respository.IActivityRepository;
import cn.l13z.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.alibaba.fastjson.JSON;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

/**
 * ClassName: ActivityDeployImpl.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 11:08 <br> Description:  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando  <br>
 */
@Component
public class ActivityDeployImpl implements IActivityDeploy {

    private final Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(),
                JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO: 非核心功能后续补充
    }
}
