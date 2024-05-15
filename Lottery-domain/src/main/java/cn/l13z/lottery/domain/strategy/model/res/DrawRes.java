package cn.l13z.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: DrawRes.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:51 <br> Description:  抽奖结果类 <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 抽奖结果类  <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawRes {

    /**
     * 用户ID
     */
    private String uId;
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 奖品ID
     */
    private String rewardId;
    /**
     * 奖品名称
     */
    private String awardName;

}
