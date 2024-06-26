package cn.l13z.lottery.domain.strategy.repository;

import cn.l13z.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.l13z.lottery.domain.strategy.model.vo.AwardBriefVO;
import java.util.List;

/**
 * ClassName: IStrategyRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 06:03 <br> Description: 策略仓储  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 策略仓储  <br>
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    boolean deductStock(Long strategyId, String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);
}
