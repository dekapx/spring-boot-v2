package com.kapx.sprintboot.kafka.consumer;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component("kafkaConsumer")
public class KafkaConsumerImpl  implements KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    @KafkaListener(topics = "${test.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(final CustomMessage greeting) {
        logger.info("Receive message on test-topic: {}", greeting.toString());
    }
}
