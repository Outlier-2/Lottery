package cn.l13z.lottery.domain.activity.respository;

import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.l13z.lottery.domain.activity.model.vo.InvoiceVO;
import cn.l13z.lottery.domain.activity.model.vo.UserTakeActivityVO;
import java.util.Date;
import java.util.List;

/**
 * ClassName: IUserTakeActivityRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 01:41 <br> Description: 用户参与仓储 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 用户参与仓储 <br>
 */
public interface IUserTakeActivityRepository {

    /**
     * 扣减个人活动参与次数
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param partakeDate       领取时间
     * @return                  更新结果
     */
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    /**
     * 领取活动
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param takeDate          领取时间
     * @param takeId            领取ID
     */
    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

    /**
     * 锁定活动领取记录
     *
     * @param uId        用户ID
     * @param activityId 活动ID
     * @param takeId     领取ID
     * @return 更新结果
     */
    int lockTackActivity(String uId, Long activityId, Long takeId);

    /**
     * 保存抽奖信息
     *
     * @param drawOrder 中奖单
     */
    void saveUserStrategyExport(DrawOrderVO drawOrder);

    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

    void updateInvoiceMqState(String uId, Long orderId, Integer mqState);

    List<InvoiceVO> scanInvoiceMqState();
}
