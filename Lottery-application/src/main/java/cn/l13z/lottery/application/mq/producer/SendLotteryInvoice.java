package cn.l13z.lottery.application.mq.producer;

import cn.l13z.lottery.domain.activity.model.vo.InvoiceVO;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * ClassName: SendLotteryInvoice.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-21 06:41 <br> Description: 发奖生成者 <br>
 * <p>
 * Modification History: <br> - 2024/5/21 AlfredOrlando 发奖生成者 <br>
 */
@Component
public class SendLotteryInvoice {

    public final String TOPIC_INVOICE = "lottery_invoice";

    private final Logger logger = LoggerFactory.getLogger(SendLotteryInvoice.class);

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public ListenableFuture<SendResult<String, Object>> sendLotteryInvoice(InvoiceVO invoice) {

        String objJson = JSON.toJSONString(invoice);

        logger.info("发送MQ消息 topic：{} bizId：{} message：{}", TOPIC_INVOICE, invoice.getuId(), objJson);

        return kafkaTemplate.send(TOPIC_INVOICE, objJson);
    }
}
