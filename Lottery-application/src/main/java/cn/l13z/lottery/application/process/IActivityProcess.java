package cn.l13z.lottery.application.process;

import cn.l13z.lottery.application.process.req.DrawProcessReq;
import cn.l13z.lottery.application.process.res.DrawProcessResult;

/**
 * ClassName: IActivityProcess.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 02:54 <br> Description: 活动流程 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 活动流程 <br>
 */
public interface IActivityProcess {

    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
