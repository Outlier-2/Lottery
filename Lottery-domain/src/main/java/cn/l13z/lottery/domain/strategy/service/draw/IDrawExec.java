package cn.l13z.lottery.domain.strategy.service.draw;

import cn.l13z.lottery.domain.strategy.model.req.DrawReq;
import cn.l13z.lottery.domain.strategy.model.res.DrawResult;

/**
 * ClassName:     IDrawExec.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-14 22:48 <br> Description: 执行创建接口 <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 执行创建接口 <br>
 */
public interface IDrawExec {

    DrawResult doDrawExec(DrawReq args);

}
