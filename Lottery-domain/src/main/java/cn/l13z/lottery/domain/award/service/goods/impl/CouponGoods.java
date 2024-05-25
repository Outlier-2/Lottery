package cn.l13z.lottery.domain.award.service.goods.impl;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.award.model.req.GoodsReq;
import cn.l13z.lottery.domain.award.model.res.DistributionRes;
import cn.l13z.lottery.domain.award.service.goods.DistributionBase;
import cn.l13z.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * ClassName: CouponGoods.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 09:27 <br> Description: 茶杯奖品 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 茶杯奖品 <br>
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟调用优惠券发放接口
        logger.info("模拟调用优惠券发放接口 uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }

}
