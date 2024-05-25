package cn.l13z.lottery.domain.rule.service.engine;

import cn.l13z.lottery.domain.rule.service.logic.ILogicFilter;
import cn.l13z.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import cn.l13z.lottery.domain.rule.service.logic.impl.UserGenderFilter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * ClassName: EngineConfig.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 20:27 <br> Description: 引擎配置 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 引擎配置 <br>
 */
public class EngineConfig {

    protected static Map<String, ILogicFilter> logicFilters = new ConcurrentHashMap<>();
    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init() {
        logicFilters.put("userAge", userAgeFilter);
        logicFilters.put("userGender", userGenderFilter);
    }

}
