package cn.l13z.lottery.domain.rule.service.logic.impl;

import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserGenderFilter.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:19 <br> Description: 性别过滤 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 性别过滤 <br>
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatterReq) {
        return decisionMatterReq.getValMap().get("gender").toString();
    }
}
