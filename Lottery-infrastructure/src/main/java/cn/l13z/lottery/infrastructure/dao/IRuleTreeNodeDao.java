package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.RuleTreeNode;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRuleTreeNodeDao.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 21:11 <br> Description: 规则树节点Dao <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 规则树节点Dao <br>
 */
@Mapper
public interface IRuleTreeNodeDao {

    /**
     * 查询规则树节点
     *
     * @param treeId 规则树ID
     * @return 规则树节点集合
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * 查询规则树节点数量
     *
     * @param treeId 规则树ID
     * @return 节点数量
     */
    int queryTreeNodeCount(Long treeId);

    /**
     * 查询规则树节点
     *
     * @param treeId 规则树ID
     * @return 节点集合
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}
