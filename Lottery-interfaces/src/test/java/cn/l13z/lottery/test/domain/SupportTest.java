package cn.l13z.lottery.test.domain;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.support.ids.IIdGenerator;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: SupportTest.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-16 02:28 <br> Description: Id生成测试 <br>
 * <p>
 * Modification History: <br> - 2024/5/16 AlfredOrlando Id生成测试 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {

    private final Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_ids() {
        logger.info("雪花算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        logger.info("日期算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.ShortCode).nextId());
        logger.info("随机算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
    }

}
