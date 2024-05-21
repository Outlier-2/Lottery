package cn.l13z.lottery.test.application;

import cn.l13z.lottery.application.mq.KafkaProducer;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: KafkaProducerTest.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-20 22:26 <br> Description: 测试kafKaProudcerTest <br>
 * <p>
 * Modification History: <br> - 2024/5/20 AlfredOrlando 测试kafKaProudcerTest <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    @Resource
    private KafkaProducer kafkaProducer;

    @Test
    public void test_send() throws InterruptedException {
        while (true) {
            kafkaProducer.send("你好，我是参加者001");
            Thread.sleep(3500);
        }
    }
}
