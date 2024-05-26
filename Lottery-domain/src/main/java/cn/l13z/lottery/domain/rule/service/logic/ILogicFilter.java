package cn.l13z.lottery.domain.rule.service.logic;

import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.model.vo.TreeNodeLineVO;
import java.util.List;

/**
 * ClassName:     LogicFilter.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-19 19:47 <br> Description: 过滤器 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 过滤器 <br>
 */
public interface ILogicFilter {

    /**
     * @param matterValue 决策值
     * @param treeNodeLineInfoList 决策节点
     * @return {@link Long }
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * @param decisionMatterReq 决策对象
     * @return {@link String } 决策值
     */
    String matterValue(DecisionMatterReq decisionMatterReq);

}
