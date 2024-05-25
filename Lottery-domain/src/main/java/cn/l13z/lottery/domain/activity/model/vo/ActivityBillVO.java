package cn.l13z.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * ClassName: ActivityBillVO.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 00:13 <br> Description: 活动账单类 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 活动账单类 <br>
 */
public class ActivityBillVO {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 开始时间
     */
    private Date beginDateTime;
    /**
     * 结束时间
     */
    private Date endDateTime;
    /**
     * 库存剩余
     */
    private Integer stockSurplusCount;
    /**
     * 活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启 Constants.ActivityState
     */
    private Integer state;
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 每人可参与次数
     */
    private Integer takeCount;
    /**
     * 已领取次数
     */
    private Integer userTakeLeftCount;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Integer getUserTakeLeftCount() {
        return userTakeLeftCount;
    }

    public void setUserTakeLeftCount(Integer userTakeLeftCount) {
        this.userTakeLeftCount = userTakeLeftCount;
    }

    @Override
    public String toString() {
        return "ActivityBillVO{" +
            "uId='" + uId + '\'' +
            ", activityId=" + activityId +
            ", activityName='" + activityName + '\'' +
            ", beginDateTime=" + beginDateTime +
            ", endDateTime=" + endDateTime +
            ", stockSurplusCount=" + stockSurplusCount +
            ", state=" + state +
            ", takeCount=" + takeCount +
            ", userTakeLeftCount=" + userTakeLeftCount +
            '}';
    }

}
