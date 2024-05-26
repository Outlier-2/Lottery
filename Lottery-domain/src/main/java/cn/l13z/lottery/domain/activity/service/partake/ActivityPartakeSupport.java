package cn.l13z.lottery.domain.activity.service.partake;

import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.l13z.lottery.domain.activity.respository.IActivityRepository;
import javax.annotation.Resource;

/**
 * ClassName: ActivityPartakeSupport.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 00:11 <br> Description: 活动参与提供类 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 活动参与提供类 <br>
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}
