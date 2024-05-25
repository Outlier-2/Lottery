package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.UserStrategyExport;
import cn.l13z.middleware.db.router.annotation.DBRouter;
import cn.l13z.middleware.db.router.annotation.DBRouterStrategy;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IUserStrategyExportDao.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-18 09:18 <br> Description: 用户策略导出结果表 <br>
 * <p>
 * Modification History: <br> - 2024/5/18 AlfredOrlando 用户策略导出结果表 <br>
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);

    /**
     * 更新发送MQ状态
     * @param userStrategyExport 发送消息
     */
    @DBRouter
    void updateInvoiceMqState(UserStrategyExport userStrategyExport);

    List<UserStrategyExport> scanInvoiceMqState();
}
