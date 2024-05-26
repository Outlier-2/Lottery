package cn.l13z.lottery.domain.activity.model.req;

import java.util.Date;

/**
 * ClassName: PartakeReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 00:05 <br> Description: 用户参与请求 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 用户参与请求 <br>
 */
public class PartakeReq {

    /**
     * 用户ID
     */
    private String uId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动领取时间
     */
    private Date partakeDate;

    public PartakeReq() {
    }

    public PartakeReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = new Date();
    }

    public PartakeReq(String uId, Long activityId, Date partakeDate) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = partakeDate;
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

    public Date getPartakeDate() {
        return partakeDate;
    }

    public void setPartakeDate(Date partakeDate) {
        this.partakeDate = partakeDate;
    }

}
