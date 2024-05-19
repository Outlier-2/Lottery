package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.UserTakeActivityCount;
import cn.l13z.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IUserTakeActivityCount.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 00:21 <br> Description: 用户参与数类 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 用户参与数类 <br>
 */
@Mapper
public interface IUserTakeActivityCountDao {
    /**
     * 查询用户领取次数信息
     * @param userTakeActivityCountReq 请求入参【活动号、用户ID】
     * @return 领取结果
     */
    @DBRouter
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTakeActivityCountReq);

    /**
     * 插入领取次数信息
     * @param userTakeActivityCount 请求入参
     */
//    @DBRouter
    void insert(UserTakeActivityCount userTakeActivityCount);

    /**
     * 更新领取次数信息
     * @param userTakeActivityCount 请求入参
     * @return 更新数量
     */
//    @DBRouter
    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);

}
