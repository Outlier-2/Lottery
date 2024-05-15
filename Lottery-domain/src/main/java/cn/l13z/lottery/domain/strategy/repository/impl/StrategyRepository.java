package cn.l13z.lottery.domain.strategy.repository.impl;

import cn.l13z.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.l13z.lottery.domain.strategy.repository.IStrategyRepository;
import cn.l13z.lottery.infrastructure.dao.IAwardDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.l13z.lottery.infrastructure.po.Award;
import cn.l13z.lottery.infrastructure.po.Strategy;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * ClassName: StrategyRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 06:27 <br> Description: 策略仓储 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 策略仓储 <br>
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}