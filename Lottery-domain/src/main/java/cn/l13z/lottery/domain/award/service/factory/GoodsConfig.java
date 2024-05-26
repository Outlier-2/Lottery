package cn.l13z.lottery.domain.award.service.factory;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.award.service.goods.IDistributionGoods;
import cn.l13z.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.l13z.lottery.domain.award.service.goods.impl.DescGoods;
import cn.l13z.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.l13z.lottery.domain.award.service.goods.impl.RedeemCodeGoods;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ClassName: GoodsConfig.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 09:35 <br> Description: 奖品配置 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 奖品配置 <br>
 */
public class GoodsConfig {

    /** 奖品发放策略组 */
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }

}

