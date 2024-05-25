package cn.l13z.lottery.test.application;

import cn.l13z.lottery.application.process.IActivityProcess;
import cn.l13z.lottery.application.process.req.DrawProcessReq;
import cn.l13z.lottery.application.process.res.DrawProcessResult;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: ActivityProcessTest.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 04:05 <br> Description: 添加测试 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 添加测试 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {

    private final Logger logger = LoggerFactory.getLogger(ActivityProcessTest.class);

    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setuId("fustack");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        logger.info("请求入参：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }

}
