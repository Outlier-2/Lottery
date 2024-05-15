package cn.l13z.lottery.domain.strategy.model.aggregates;

import cn.l13z.lottery.infrastructure.po.Strategy;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: StrategyRich.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 06:07 <br> Description: 策略聚合类  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 策略聚合类 <br>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRich {

    // 策略ID
    private Long strategyId;
    // 策略配置
    private Strategy strategy;
    // 策略明细
    private List<StrategyDetail> strategyDetailList;

}
