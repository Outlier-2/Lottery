package cn.l13z.lottery.infrastructure.po;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Award.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:34 <br> Description: 奖品PO <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 奖品PO <br>
 */
@Data
public class Award {

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 奖品ID
     */
    private String awardId;
    /**
     * 奖品类型（文字描述、兑换码、优惠券、实物奖品暂无）
     */
    private String awardType;
    /**
     * 奖品数量
     */
    private Integer awardCount;
    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 奖品内容「文字描述、Key、码」
     */
    private String awardContent;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * updateTime
     */
    private Date updateTime;

}
