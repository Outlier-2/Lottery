package cn.l13z.lottery.domain.activity.service.stateflow.event;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.common.Constants.ActivityState;
import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * ClassName: ArraignmentState.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 21:34 <br> Description: 提审 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 提审 <br>
 */
@Component
public class ArraignmentState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.PASS);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核通过完成")
            : Result.buildErrorResult("活动状态变更失败");

    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核拒绝完成")
            : Result.buildErrorResult("活动状态变更失败");

    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.EDIT);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核撤销回到编辑中")
            : Result.buildErrorResult("活动状态变更失败");

    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核关闭完成")
            : Result.buildErrorResult("活动状态变更失败");

    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currentState) {
        return null;
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currentState) {
        return null;
    }
}
