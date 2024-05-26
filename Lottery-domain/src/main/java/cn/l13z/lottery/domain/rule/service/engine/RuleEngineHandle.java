package cn.l13z.lottery.domain.rule.service.engine;

import cn.l13z.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.model.res.EngineResult;
import cn.l13z.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.l13z.lottery.domain.rule.repository.IRuleRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ClassName: RuleEngineHandle.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:49 <br> Description: 规则赢球处理器 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 规则赢球处理器 <br>
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matterReq) {
        //决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matterReq.getTreeId());

        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // 决策节点
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matterReq);

        // 决策结果
        return new EngineResult(matterReq.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());


    }
}
