package com.kapx.sprintboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component("kafkaConsumer")
public class KafkaConsumerImpl  implements KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    @KafkaListener(topics = "${test.topic}")
    public void onMessage(final ConsumerRecord<?, ?> consumerRecord) {
        logger.info("Receiver on test-topic: " + consumerRecord.toString());
    }
}
