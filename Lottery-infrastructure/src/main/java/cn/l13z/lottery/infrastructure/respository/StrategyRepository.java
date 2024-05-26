package cn.l13z.lottery.infrastructure.respository;

import cn.l13z.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.l13z.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.l13z.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.l13z.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.l13z.lottery.domain.strategy.repository.IStrategyRepository;
import cn.l13z.lottery.infrastructure.dao.IAwardDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.l13z.lottery.infrastructure.po.Award;
import cn.l13z.lottery.infrastructure.po.Strategy;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * ClassName: StrategyRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 06:27 <br> Description: 策略仓储 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 策略仓储 <br>
 */
@Slf4j
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }

        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {

        Award award = awardDao.queryAwardInfo(awardId);

        // 可以使用 BeanUtils.copyProperties(award, awardBriefVO)、或者基于ASM实现的Bean-Mapping，但在效率上最好的依旧是硬编码
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        awardBriefVO.setAwardId(award.getAwardId());
        awardBriefVO.setAwardType(award.getAwardType());
        awardBriefVO.setAwardName(award.getAwardName());
        awardBriefVO.setAwardContent(award.getAwardContent());

        return awardBriefVO;
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(req);
        return count == 1;
    }

}
