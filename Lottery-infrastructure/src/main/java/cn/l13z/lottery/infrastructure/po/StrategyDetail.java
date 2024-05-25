package cn.l13z.lottery.infrastructure.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ClassName: StrategyDetail.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:41 <br> Description: 策略详情PO <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 策略详情PO <br>
 */
@Data
public class StrategyDetail {

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 奖品ID
     */
    private String awardId;
    /**
     * 奖品数量
     */
    private Integer awardCount;
    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 剩余库存
     */
    private Integer awardSurplusCount;

}
