package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.common.Result;
import cn.l13z.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.l13z.lottery.infrastructure.po.UserTakeActivity;
import cn.l13z.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:     IUserTakeActivityDao.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-18 09:02 <br> Description: 用户活动表 <br>
 * <p>
 * Modification History: <br> - 2024/5/18 AlfredOrlando 用户活动表 <br>
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);

    /**
     * 锁定活动领取记录
     *
     * @param userTakeActivity  入参
     * @return                  更新结果
     */
    int lockTackActivity(UserTakeActivity userTakeActivity);

    @DBRouter
    UserTakeActivity queryNoConsumedTakeActivityOrder(UserTakeActivity userTakeActivity);
}
