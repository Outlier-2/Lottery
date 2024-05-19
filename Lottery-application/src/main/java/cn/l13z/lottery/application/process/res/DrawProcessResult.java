package cn.l13z.lottery.application.process.res;

import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * ClassName: DrawProcessResult.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 03:23 <br> Description: 抽奖结果 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 抽奖结果 <br>
 */
public class DrawProcessResult extends Result {

    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }

}
