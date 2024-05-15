package cn.l13z.lottery.domain.award.service.goods;

import cn.l13z.lottery.domain.award.model.req.GoodsReq;
import cn.l13z.lottery.domain.award.model.res.DistributionRes;

/**
 * ClassName:     IDistributionGoods.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-15 09:16 <br> Description: 派发奖品接口 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 派发奖品接口 <br>
 */
public interface IDistributionGoods {

    /**
     * 敬佩排放接口，敬佩类型(1: 文字描述， 2.兑换码 4.实物奖品)
     * @param req - 物品信息
     * @return {@link DistributionRes }
     */
    DistributionRes doDistribution(GoodsReq req);

    Integer getDistributionGoodsName();
}
