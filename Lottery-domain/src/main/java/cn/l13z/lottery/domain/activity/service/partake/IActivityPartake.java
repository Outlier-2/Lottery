package cn.l13z.lottery.domain.activity.service.partake;

import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.res.PartakeResult;

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

}
