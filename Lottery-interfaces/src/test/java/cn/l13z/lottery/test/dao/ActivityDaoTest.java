package cn.l13z.lottery.test.dao;

import cn.l13z.lottery.infrastructure.dao.IActivityDao;
import cn.l13z.lottery.infrastructure.po.Activity;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: ActivityDaoTest.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-18 20:39 <br> Description: 活动测试 <br>
 * <p>
 * Modification History: <br> - 2024/5/18 AlfredOrlando 活动测试 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityDaoTest {

    private Logger logger = LoggerFactory.getLogger(ActivityDaoTest.class);

    @Resource
    private IActivityDao activityDao;

    @Test
    public void test_queryActivityById() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(activity));
    }

}
