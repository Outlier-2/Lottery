package cn.l13z.lottery.rpc.req;

import java.io.Serializable;

/**
 * ClassName: DrawReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 22:43 <br> Description: 抽奖 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 抽奖 <br>
 */
public class DrawReq implements Serializable {

    /** 用户ID */
    private String uId;
    /** 活动ID */
    private Long activityId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
    }

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
}
