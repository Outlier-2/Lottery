package cn.l13z.lottery.domain.strategy.model.vo;

import lombok.Data;

/**
 * ClassName: DrawAwardInfo.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 07:55 <br> Description:  中奖信息类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 中奖信息类  <br>
 */
@Data
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    private Integer awardType;

    private String awardContent;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}

