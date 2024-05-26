package cn.l13z.lottery.domain.activity.model.vo;

/**
 * ClassName: ActivityPartakeRecordVO.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-25 01:19 <br> Description: 活动参与记录VO <br>
 * <p>
 * Modification History: <br> - 2024/5/25 AlfredOrlando 活动参与记录VO <br>
 */
public class ActivityPartakeRecordVO {

    /**
     * 用户ID
     */
    private String uId;
    /**
     * activity 活动ID
     */
    private Long activityId;
    /**
     * 库存
     */
    private Integer stockCount;
    /**
     * activity 库存剩余
     */
    private Integer stockSurplusCount;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    @Override
    public String toString() {
        return "ActivityPartakeRecordVO{" +
            "uId='" + uId + '\'' +
            ", activityId=" + activityId +
            ", stockCount=" + stockCount +
            ", stockSurplusCount=" + stockSurplusCount +
            '}';
    }
}
