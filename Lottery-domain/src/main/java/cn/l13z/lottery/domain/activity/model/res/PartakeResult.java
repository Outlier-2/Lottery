package cn.l13z.lottery.domain.activity.model.res;

import cn.l13z.lottery.common.Result;

/**
 * ClassName: PartakeResult.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 00:06 <br> Description: 参与结果 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 参与结果 <br>
 */
public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

}
