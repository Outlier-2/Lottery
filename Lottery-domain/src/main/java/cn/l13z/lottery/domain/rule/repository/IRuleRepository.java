package cn.l13z.lottery.domain.rule.repository;

import cn.l13z.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * ClassName: IRuleRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:51 <br> Description: 策略规则仓储 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 策略规则仓储 <br>
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     * @param treeId 决策树ID
     * @return {@link TreeRuleRich } 决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
