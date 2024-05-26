package cn.l13z.lottery.infrastructure.respository;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.activity.model.req.PartakeReq;
import cn.l13z.lottery.domain.activity.model.res.StockResult;
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
import cn.l13z.lottery.infrastructure.util.RedisUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(ActivityRepository.class);

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
    @Resource
    private RedisUtil redisUtil;

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

        logger.info("查询活动到的活动为：{}", activity);

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
        activityBillVO.setStockCount(activity.getStockCount());
        activityBillVO.setStockSurplusCount(activity.getStockSurplusCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(
            null == userTakeActivityCount ? null : userTakeActivityCount.getLeftCount());

        logger.info("查询活动账单到结果为：{} 其中库存为：{}", activityBillVO,activityBillVO.getStockCount());
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

    @Override
    public StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount) {
        //  1. 获取抽奖活动库存 Key
        String stockKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activityId);

        //判断Redis中是否存在库存Key
        if (!redisUtil.hasKey(stockKey)) {
            // 如果Redis中没有库存Key，从数据库中查到库存值
            stockCount = activityDao.queryActivityById(activityId).getStockCount();

            // 将库存值保存到Redis中
            redisUtil.set(stockKey, stockCount);
        }

        logger.info("抽奖活动{}用户{}秒杀，库存剩余：{}", activityId, uId, redisUtil.get(stockKey));
        // 2. 扣减库存，目前占用库存数
        Integer stockUsedCount = (int) redisUtil.incr(stockKey, 1);





        // 3. 超出库存判断，进行恢复原始库存
        if (stockUsedCount > stockCount) {
            redisUtil.decr(stockKey, 1);
            return new StockResult(Constants.ResponseCode.OUT_OF_STOCK.getCode(),
                Constants.ResponseCode.OUT_OF_STOCK.getInfo());
        }

        // 4. 以活动库存占用编号，生成对应加锁Key，细化锁的颗粒度
        String stockTokenKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN(activityId, stockUsedCount);

        // 5. 使用 Redis.setNx 加一个分布式锁
        boolean lockToken = redisUtil.setNx(stockTokenKey, 350L);
        if (!lockToken) {
            logger.info("抽奖活动{}用户秒杀{}扣减库存，分布式锁失败：{}", activityId, uId, stockTokenKey);
            return new StockResult(Constants.ResponseCode.ERR_TOKEN.getCode(),
                Constants.ResponseCode.ERR_TOKEN.getInfo());
        }

        return new StockResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(),
            stockTokenKey, stockCount - stockUsedCount);

    }

    @Override
    public void recoverActivityCacheStockByRedis(Long activityId, String tokenKey, String code) {
        // 删除分布式锁 Key
        redisUtil.del(tokenKey);
    }

}
