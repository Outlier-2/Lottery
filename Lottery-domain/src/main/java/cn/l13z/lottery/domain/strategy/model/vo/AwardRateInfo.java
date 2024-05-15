package cn.l13z.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: AwardRateInfo.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:57 <br> Description: 奖品中奖信息 <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 奖品中奖信息 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRateInfo {

    // 奖品ID
    private String awardId;
    // 中奖概率
    private BigDecimal awardRate;

}
