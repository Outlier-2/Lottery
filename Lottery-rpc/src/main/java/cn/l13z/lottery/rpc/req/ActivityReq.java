package cn.l13z.lottery.rpc.req;

import java.io.Serializable;

/**
 * 请求活动信息的请求对象。
 * @author AlfredOrlando
 */
public class ActivityReq implements Serializable {

    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
