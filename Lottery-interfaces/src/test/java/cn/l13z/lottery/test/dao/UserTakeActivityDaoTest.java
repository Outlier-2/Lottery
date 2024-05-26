package cn.l13z.lottery.test.dao;

import cn.l13z.lottery.infrastructure.dao.IUserTakeActivityDao;
import cn.l13z.lottery.infrastructure.po.UserTakeActivity;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: DBRouteTest.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-18 08:59 <br> Description: 分库分表测试 <br>
 * <p>
 * Modification History: <br> - 2024/5/18 AlfredOrlando 分库分表测试 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {
    private Logger logger = LoggerFactory.getLogger(UserTakeActivityDaoTest.class);

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId("Ukdli109op89oi"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("Uhdgkw766120d");

        userTakeActivityDao.insert(userTakeActivity);
    }

}
