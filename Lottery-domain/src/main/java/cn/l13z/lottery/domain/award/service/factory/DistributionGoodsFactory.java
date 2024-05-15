package cn.l13z.lottery.domain.award.service.factory;

import static cn.l13z.lottery.domain.award.service.factory.GoodsConfig.goodsMap;

import cn.l13z.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * ClassName: DistributionGoodsFactory.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 09:40 <br> Description: 派发奖品工程 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 派发奖品工程 <br>
 */
@Service
public class DistributionGoodsFactory {

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
