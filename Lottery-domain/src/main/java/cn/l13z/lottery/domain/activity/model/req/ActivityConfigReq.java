package cn.l13z.lottery.domain.activity.model.req;

import cn.l13z.lottery.domain.activity.model.aggregation.ActivityConfigRich;

/**
 * ClassName:     ActivityConfigReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-15 10:27 <br> Description:  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando  <br>
 */
public class ActivityConfigReq {

    /** 活动ID */
    private Long activityId;

    /** 活动配置信息 */
    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityConfigRich getActivityConfigRich() {
        return activityConfigRich;
    }

    public void setActivityConfigRich(ActivityConfigRich activityConfigRich) {
        this.activityConfigRich = activityConfigRich;
    }

}
