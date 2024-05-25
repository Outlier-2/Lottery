package cn.l13z.lottery.domain.rule.service.engine;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.model.res.EngineResult;
import cn.l13z.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.l13z.lottery.domain.rule.model.vo.TreeRootVO;
import cn.l13z.lottery.domain.rule.service.logic.ILogicFilter;
import cn.l13z.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import cn.l13z.lottery.domain.rule.service.logic.impl.UserGenderFilter;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: EngineBase.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:30 <br> Description: 引擎通用流程 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 引擎通用流程 <br>
 */
public class EngineBase extends EngineConfig implements IEngineFilter {

    private Logger logger = LoggerFactory.getLogger(EngineConfig.class);

    @Override
    public EngineResult process(DecisionMatterReq matterReq) {
        throw new RuntimeException("未实现规则引擎服务");
    }

    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatterReq matterReq) {
        TreeRootVO treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();

        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNodeVO treeNodeInfo = treeNodeMap.get(rootNodeId);

        // 节点类型[NodeType]；1子叶、2果实
        while (Constants.NodeType.STEM.equals(treeNodeInfo.getNodeType())) {
            String ruleKey = treeNodeInfo.getRuleKey();
            ILogicFilter logicFilter = logicFilters.get(ruleKey);
            String matterValue = logicFilter.matterValue(matterReq);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), matterReq.getUserId(), matterReq.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }

        return treeNodeInfo;
    }
}
