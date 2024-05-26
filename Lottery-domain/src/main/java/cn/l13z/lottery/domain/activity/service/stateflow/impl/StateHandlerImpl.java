package cn.l13z.lottery.domain.activity.service.stateflow.impl;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.service.stateflow.IStateHandler;
import cn.l13z.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

/**
 * ClassName: StateHandlerImpl.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 21:51 <br> Description: 状态修改类 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 状态修改类 <br>
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {

    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).arraignment(activityId, currentStatus);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkPass(activityId, currentStatus);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).close(activityId, currentStatus);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).open(activityId, currentStatus);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).doing(activityId, currentStatus);
    }

}
