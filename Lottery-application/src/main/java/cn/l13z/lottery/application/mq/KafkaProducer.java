package cn.l13z.lottery.application.mq;

import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * ClassName: KafkaProducer.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-20 22:02 <br> Description: kafkaMQ生产者 <br>
 * <p>
 * Modification History: <br> - 2024/5/20 AlfredOrlando kafkaMQ生产者 <br>
 */
@Component
public class KafkaProducer {

    public static final String TOPIC_TEST = "Hello-Kafka";
    public static final String TOPIC_GROUP = "test-consumer-group";
    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Resource
    private KafkaTemplate<String, Object> kafKaTemplate;

    public void send(Object obj) {
        String obj2String = JSON.toJSONString(obj);

        // 异步发送消息
        ListenableFuture<SendResult<String, Object>> future = kafKaTemplate.send(TOPIC_TEST, obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info(TOPIC_TEST + "生产者发送消息失败" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                logger.info(TOPIC_TEST + "生产者发送消息成功" + stringObjectSendResult.getRecordMetadata().toString());
            }
        });
    }
}
