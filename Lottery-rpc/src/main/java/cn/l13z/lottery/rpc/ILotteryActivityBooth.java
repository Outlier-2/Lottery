package cn.l13z.lottery.rpc;

import cn.l13z.lottery.rpc.req.DrawReq;
import cn.l13z.lottery.rpc.req.QuantificationDrawReq;
import cn.l13z.lottery.rpc.res.DrawRes;

/**
 * ClassName: ILotteryActivityBooth.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 22:40 <br> Description: 抽奖接口 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 抽奖接口 <br>
 */
public interface ILotteryActivityBooth {

    /**
     * 指定活动抽奖
     * @param drawReq 请求参数
     * @return        抽奖结果
     */
    DrawRes doDraw(DrawReq drawReq);

    /**
     * 量化人群抽奖
     * @param quantificationDrawReq 请求参数
     * @return                      抽奖结果
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);

}
