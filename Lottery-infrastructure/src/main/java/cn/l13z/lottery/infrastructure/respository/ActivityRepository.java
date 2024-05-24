package cn.l13z.lottery.infrastructure.respository;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.l13z.lottery.domain.activity.model.vo.ActivityVO;
import cn.l13z.lottery.domain.activity.model.vo.AlterStateVO;
import cn.l13z.lottery.domain.activity.model.vo.AwardVO;
import cn.l13z.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.l13z.lottery.domain.activity.model.vo.StrategyVO;
import cn.l13z.lottery.domain.activity.respository.IActivityRepository;
import cn.l13z.lottery.infrastructure.dao.IActivityDao;
import cn.l13z.lottery.infrastructure.dao.IAwardDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDao;
import cn.l13z.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.l13z.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import cn.l13z.lottery.infrastructure.po.Activity;
import cn.l13z.lottery.infrastructure.po.Award;
import cn.l13z.lottery.infrastructure.po.Strategy;
import cn.l13z.lottery.infrastructure.po.StrategyDetail;
import cn.l13z.lottery.infrastructure.po.UserTakeActivityCount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * ClassName: ActivityRepository.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-15 20:35 <br> Description: 活动仓储 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 活动仓储 <br>
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState,
        Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, ((Constants.ActivityState) beforeState).getCode(),
            ((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {
        // 查询活动
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        // 查询领取次数
        UserTakeActivityCount userTakeActivityCountReq = new UserTakeActivityCount();
        userTakeActivityCountReq.setuId(req.getuId());
        userTakeActivityCountReq.setActivityId(req.getActivityId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserTakeActivityCount(
            userTakeActivityCountReq);
        // 封装结果信息
        ActivityBillVO activityBillVO = new ActivityBillVO();
        activityBillVO.setuId(req.getuId());
        activityBillVO.setActivityId(req.getActivityId());
        activityBillVO.setActivityName(activity.getActivityName());
        activityBillVO.setBeginDateTime(activity.getBeginDateTime());
        activityBillVO.setEndDateTime(activity.getEndDateTime());
        activityBillVO.setTakeCount(activity.getTakeCount());
        activityBillVO.setStockSurplusCount(activity.getStockCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(
            null == userTakeActivityCount ? null : userTakeActivityCount.getLeftCount());

        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {
        return activityDao.subtractionActivityStock(activityId);
    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        List<Activity> activityList = activityDao.scanToDoActivityList(id);
        List<ActivityVO> activityVOList = new ArrayList<>(activityList.size());
        for (Activity activity : activityList) {
            ActivityVO activityVO = new ActivityVO();
            activityVO.setId(activity.getId());
            activityVO.setActivityId(activity.getActivityId());
            activityVO.setActivityName(activity.getActivityName());
            activityVO.setBeginDateTime(activity.getBeginDateTime());
            activityVO.setEndDateTime(activity.getEndDateTime());
            activityVO.setState(activity.getState());
            activityVOList.add(activityVO);
        }
        return activityVOList;
    }

}
