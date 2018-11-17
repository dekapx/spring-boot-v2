package com.kapx.sprintboot.kafka.producer;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("kafkaProducer")
public class KafkaProducerImpl implements KafkaProducer {
    private Logger logger = LoggerFactory.getLogger(KafkaProducerImpl.class);

    @Value("${test.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, CustomMessage> kafkaTemplate;

    public void send(final CustomMessage payload) {
        kafkaTemplate.send(topic, payload);
        logger.info("Message: " + payload.getMessage() + " sent to topic: " + topic);
    }
}
