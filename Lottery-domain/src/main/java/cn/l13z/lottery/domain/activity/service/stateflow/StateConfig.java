package cn.l13z.lottery.domain.activity.service.stateflow;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.activity.service.stateflow.event.ArraignmentState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.CloseState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.DoingState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.EditingState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.OpenState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.PassState;
import cn.l13z.lottery.domain.activity.service.stateflow.event.RefuseState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * ClassName: StateConfig.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 21:31 <br> Description: 状态配置类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 状态配置类 <br>
 */

public class StateConfig {


    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private CloseState closeState;
    @Resource
    private DoingState doingState;
    @Resource
    private EditingState editingState;
    @Resource
    private OpenState openState;
    @Resource
    private PassState passState;
    @Resource
    private RefuseState refuseState;

    protected Map<Enum<Constants.ActivityState>, AbstractState> stateGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateGroup.put(Constants.ActivityState.ARRAIGNMENT, arraignmentState);
        stateGroup.put(Constants.ActivityState.CLOSE, closeState);
        stateGroup.put(Constants.ActivityState.DOING, doingState);
        stateGroup.put(Constants.ActivityState.EDIT, editingState);
        stateGroup.put(Constants.ActivityState.OPEN, openState);
        stateGroup.put(Constants.ActivityState.PASS, passState);
        stateGroup.put(Constants.ActivityState.REFUSE, refuseState);
    }
}
