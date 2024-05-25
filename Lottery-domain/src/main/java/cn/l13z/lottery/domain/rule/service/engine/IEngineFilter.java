package cn.l13z.lottery.domain.rule.service.engine;

import cn.l13z.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.l13z.lottery.domain.rule.model.res.EngineResult;

/**
 * ClassName:     IEngineFilter.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-19 20:24 <br> Description: 引擎过滤 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 引擎过滤 <br>
 */
public interface IEngineFilter {
    EngineResult process(final DecisionMatterReq matterReq);
}
