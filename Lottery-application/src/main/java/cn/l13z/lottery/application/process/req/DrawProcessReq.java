package cn.l13z.lottery.application.process.req;

/**
 * ClassName: DrawProcessReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 03:23 <br> Description: 抽奖请求 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 抽奖请求 <br>
 */
public class DrawProcessReq {

    /** 用户ID */
    private String uId;
    /** 活动ID */
    private Long activityId;

    public DrawProcessReq() {
    }

    public DrawProcessReq(String uId, Long activityId) {
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
