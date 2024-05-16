package cn.l13z.lottery.domain.strategy.service.draw;

import cn.l13z.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.l13z.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.l13z.lottery.domain.strategy.repository.IStrategyRepository;
import javax.annotation.Resource;

/**
 * ClassName: DrawStrategySupport.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 07:41 <br> Description: 抽奖策略支持 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 抽奖策略支持 <br>
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}
