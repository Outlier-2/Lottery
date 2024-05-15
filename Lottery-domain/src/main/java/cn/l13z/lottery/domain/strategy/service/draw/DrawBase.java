package cn.l13z.lottery.domain.strategy.service.draw;

import cn.l13z.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.l13z.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: DrawBase.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 05:50 <br> Description: 抽奖基本类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 抽奖基本类 <br>
 */
@Slf4j
public class DrawBase extends DrawConfig {

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {
            return;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        log.info("strategyId:{}, strategyMode:{}, awardRateInfoList:{}", strategyId, strategyMode, awardRateInfoList);

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);

    }
}
