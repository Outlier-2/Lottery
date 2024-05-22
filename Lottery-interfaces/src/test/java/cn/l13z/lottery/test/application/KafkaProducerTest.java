package cn.l13z.lottery.test.application;

import cn.l13z.lottery.application.mq.producer.SendLotteryInvoice;
import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.activity.model.vo.InvoiceVO;
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

    private Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    @Resource
    private SendLotteryInvoice sendLotteryInvoice;

    @Test
    public void test_send() throws InterruptedException {

        InvoiceVO invoice = new InvoiceVO();
        invoice.setuId("fustack");
        invoice.setOrderId(String.valueOf(1444540456057864192L));
        invoice.setAwardId("3");
        invoice.setAwardType(Constants.AwardType.DESC.getCode());
        invoice.setAwardName("Code");
        invoice.setAwardContent("苹果电脑");
        invoice.setShippingAddress(null);
        invoice.setExtInfo(null);

        sendLotteryInvoice.sendLotteryInvoice(invoice);

        while (true){
            Thread.sleep(10000);
        }
    }
}
