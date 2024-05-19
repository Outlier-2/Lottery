package cn.l13z.lottery.domain.activity.service.deploy;

import cn.l13z.lottery.domain.activity.model.req.ActivityConfigReq;
import org.springframework.stereotype.Component;

/**
 * ClassName:     IActivityDeploy.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * <p>
 * Created:  2024-05-15 10:24 <br> Description: 活动配置接口 <br>
 * <p>
 * Modification History: <br> - 2024/5/15 AlfredOrlando 活动配置接口 <br>
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     * @param req  活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 更新活动信息
     * @param req  活动配置信息
     */
    void updateActivity(ActivityConfigReq req);


}