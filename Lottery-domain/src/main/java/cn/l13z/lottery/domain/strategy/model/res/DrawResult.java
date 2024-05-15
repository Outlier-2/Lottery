package cn.l13z.lottery.domain.strategy.model.res;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: DrawResult.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:51 <br> Description:  抽奖结果类 <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 抽奖结果类  <br>
 */
@Data
public class DrawResult {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();

    /**
     * 中奖奖品信息
     */
    private DrawAwardInfo drawAwardInfo;

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }

}
