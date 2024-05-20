package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.RuleTreeNodeLine;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRuleTreeNodeLineDao.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 21:11 <br> Description: 规则树连线Dao <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 规则树连线Dao <br>
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    /**
     * 查询规则树节点连线集合
     *
     * @param req 入参
     * @return 规则树节点连线集合
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     *
     * @param treeId 规则树ID
     * @return 规则树连线数量
     */
    int queryTreeNodeLineCount(Long treeId);
}
