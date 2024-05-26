package cn.l13z.lottery.domain.rule.model.aggregates;

import cn.l13z.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.l13z.lottery.domain.rule.model.vo.TreeRootVO;
import java.util.Map;

/**
 * ClassName: TreeRuleRich.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:38 <br> Description:  <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando  <br>
 */
public class TreeRuleRich {

    /** 树根信息 */
    private TreeRootVO treeRoot;
    /** 树节点ID -> 子节点 */
    private Map<Long, TreeNodeVO> treeNodeMap;

    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }

}
