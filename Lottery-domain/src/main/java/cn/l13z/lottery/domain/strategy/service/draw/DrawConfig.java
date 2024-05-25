package cn.l13z.lottery.domain.strategy.service.draw;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * ClassName: DrawConfig.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-14 22:54 <br> Description: 奖品配置类 <br>
 * <p>
 * Modification History: <br> - 2024/5/14 AlfredOrlando 奖品配置类 <br>
 */
public class DrawConfig {

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();
    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    @PostConstruct
    public void init() {
        drawAlgorithmGroup.put(Constants.StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}
