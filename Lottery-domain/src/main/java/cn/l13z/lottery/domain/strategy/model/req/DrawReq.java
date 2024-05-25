package cn.l13z.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: DrawReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:49 <br> Description: 抽奖请求类  <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando  抽奖请求类 <br>
 */
@Data
public class DrawReq {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }

}
