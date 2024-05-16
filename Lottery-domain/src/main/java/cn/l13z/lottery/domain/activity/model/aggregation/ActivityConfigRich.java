package cn.l13z.lottery.domain.activity.model.aggregation;

import cn.l13z.lottery.domain.activity.model.vo.ActivityVO;
import cn.l13z.lottery.domain.activity.model.vo.AwardVO;
import cn.l13z.lottery.domain.activity.model.vo.StrategyVO;
import java.util.List;

/**
 * ClassName: ActivityConfigRich.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 20:06 <br> Description: 活动聚合类  <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 活动聚合类 <br>
 */
public class ActivityConfigRich {
    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;
    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }

    public ActivityVO getActivity() {
        return activity;
    }

    public void setActivity(ActivityVO activity) {
        this.activity = activity;
    }

    public StrategyVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyVO strategy) {
        this.strategy = strategy;
    }

    public List<AwardVO> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardVO> awardList) {
        this.awardList = awardList;
    }
}
