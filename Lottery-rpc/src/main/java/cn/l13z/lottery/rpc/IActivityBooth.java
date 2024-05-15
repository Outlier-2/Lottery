package cn.l13z.lottery.rpc;

import cn.l13z.lottery.rpc.req.ActivityReq;
import cn.l13z.lottery.rpc.res.ActivityRes;

/**

 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 * @author AlfredOrlando
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);

}
