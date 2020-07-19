package com.kapx.sprintboot.kafka.consumer;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component("kafkaConsumer")
public class KafkaConsumerImpl  implements KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(final CustomMessage message) {
        log.info("Receive message on topic: {}", message.toString());
    }
}
