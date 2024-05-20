package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRuleTreeDao.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 21:11 <br> Description: 规则树Dao <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 规则树Dao <br>
 */
@Mapper
public interface IRuleTreeDao {


    /**
     * 规则树查询
     * @param id ID
     * @return   规则树
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * 规则树简要信息查询
     * @param treeId 规则树ID
     * @return       规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);
}
