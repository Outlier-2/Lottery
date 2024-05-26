package cn.l13z.lottery.domain.rule.service.logic.impl;

import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;


/**
 * ClassName: UserAgeFilter.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:15 <br> Description: 用户年龄过滤 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 用户年龄过滤 <br>
 */
@Component
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatterReq) {
        return decisionMatterReq.getValMap().get("age").toString();
    }
}
