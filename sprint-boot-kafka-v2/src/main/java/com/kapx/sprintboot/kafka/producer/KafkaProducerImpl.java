package com.kapx.sprintboot.kafka.producer;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("kafkaProducer")
public class KafkaProducerImpl implements KafkaProducer {

    @Value("${kafka.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, CustomMessage> kafkaTemplate;

    public void send(final CustomMessage payload) {
        kafkaTemplate.send(topic, payload);
        log.info("Message: " + payload.getMessage() + " sent to topic: " + topic);
    }
}
