package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.Activity;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author AlfredOrlando
 */
@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    int deductStock(StrategyDetail req);

    List<String> queryNoStockStrategyAwardList(Long strategyId);
}
