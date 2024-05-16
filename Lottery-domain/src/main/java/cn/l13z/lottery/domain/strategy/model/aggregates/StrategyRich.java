package cn.l13z.lottery.domain.strategy.model.aggregates;

import cn.l13z.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.l13z.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import java.util.List;
import lombok.Builder;
import lombok.Data;

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
public class StrategyRich {

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略配置
     */
    private StrategyBriefVO strategy;

    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public StrategyBriefVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyBriefVO strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetailBriefVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }

}
