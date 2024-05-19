package cn.l13z.lottery.domain.activity.service.partake;

import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.res.PartakeResult;
import cn.l13z.lottery.domain.activity.model.vo.DrawOrderVO;

/**
 * ClassName:     IActivityPartake.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-15 21:09 <br> Description: IActivityPartake <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando IActivityPartake <br>
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param partakeReq - 入参
     * @return {@link PartakeResult } 领取结果
     */
    PartakeResult doPartake(PartakeReq partakeReq);

    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);
}
