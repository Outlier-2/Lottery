package cn.l13z.lottery.domain.activity.model.vo;

/**
 * ClassName: UserTakeActivityVO.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-21 19:44 <br> Description: 用户抽奖结果 <br>
 * <p>
 * Modification History: <br> - 2024/5/21 AlfredOrlando 用户抽奖结果 <br>
 */
public class UserTakeActivityVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 活动单使用状态 0未使用、1已使用 Constants.TaskState
     */
    private Integer state;



    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserTakeActivityVO{" +
            "activityId=" + activityId +
            ", takeId=" + takeId +
            ", strategyId=" + strategyId +
            ", state=" + state +
            '}';
    }
}
