package cn.l13z.lottery.domain.strategy.service.algorithm.impl;

import cn.l13z.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import java.security.SecureRandom;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * ClassName: SingleRateRandomDrawAlgorithm.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 05:42 <br> Description: 单项随机概率抽奖 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 单项随机概率抽奖 <br>
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);

        // 返回结果
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return "未中奖";
        }

        return awardId;
    }
}
