package cn.l13z.lottery.interfaces;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.infrastructure.dao.IActivityDao;
import cn.l13z.lottery.infrastructure.po.Activity;
import cn.l13z.lottery.rpc.IActivityBooth;
import cn.l13z.lottery.rpc.dto.ActivityDto;
import cn.l13z.lottery.rpc.req.ActivityReq;
import cn.l13z.lottery.rpc.res.ActivityRes;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author L13Z
 * 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}
