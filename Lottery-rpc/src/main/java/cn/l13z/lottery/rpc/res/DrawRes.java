package cn.l13z.lottery.rpc.res;

import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.rpc.dto.AwardDTO;
import java.io.Serializable;

/**
 * ClassName: DrawRes.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 22:42 <br> Description: 抽奖结果 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 抽奖结果 <br>
 */
public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

}
