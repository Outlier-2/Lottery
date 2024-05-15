package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.Activity;
import cn.l13z.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author AlfredOrlando
 */
@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);
}
