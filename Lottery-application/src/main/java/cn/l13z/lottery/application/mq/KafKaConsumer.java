package cn.l13z.lottery.application.mq;

import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * ClassName: KafKaConsumer.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-20 21:59 <br> Description: kafkaMQ消费者 <br>
 * <p>
 * Modification History: <br> - 2024/5/20 AlfredOrlando kafkaMQ消费者 <br>
 */
@Component
public class KafKaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafKaConsumer.class);

    //
    @KafkaListener(topics = KafkaProducer.TOPIC_TEST, groupId = KafkaProducer.TOPIC_GROUP)
    public void topicTest(ConsumerRecord<?, ?> record, Acknowledgment ack,
        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            logger.info("topic_test 消费了： Topic：" + topic
                + "  Message:"
                + msg);
            ack.acknowledge();
        }
    }
}
