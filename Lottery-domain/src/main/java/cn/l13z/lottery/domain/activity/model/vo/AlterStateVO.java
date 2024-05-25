package cn.l13z.lottery.domain.activity.model.vo;

/**
 * ClassName: AlterStateVO.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 20:39 <br> Description:  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando  <br>
 */
public class AlterStateVO {

    /** 活动ID */
    private Long activityId;

    /** 更新前状态 */
    private Integer beforeState;

    /** 更新后状态 */
    private Integer afterState;

    public AlterStateVO() {
    }

    public AlterStateVO(Long activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getBeforeState() {
        return beforeState;
    }

    public void setBeforeState(Integer beforeState) {
        this.beforeState = beforeState;
    }

    public Integer getAfterState() {
        return afterState;
    }

    public void setAfterState(Integer afterState) {
        this.afterState = afterState;
    }

    @Override
    public String toString() {
        return "AlterStateVO{" +
            "activityId=" + activityId +
            ", beforeState=" + beforeState +
            ", afterState=" + afterState +
            '}';
    }


}
