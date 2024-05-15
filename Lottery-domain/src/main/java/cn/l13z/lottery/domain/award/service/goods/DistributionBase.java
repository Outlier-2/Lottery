package cn.l13z.lottery.domain.award.service.goods;

import cn.l13z.lottery.domain.award.repository.IAwardRepository;
import cn.l13z.lottery.domain.award.service.factory.GoodsConfig;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ClassName: DistributionBase.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 09:24 <br> Description: 派发抽象类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 派发抽象类 <br>
 */
public class DistributionBase extends GoodsConfig {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState,
        String awardStateInfo) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }

}
