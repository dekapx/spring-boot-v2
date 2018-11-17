package com.kapx.sprintboot.kafka.producer;

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
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(final String payload) {
        kafkaTemplate.send(topic, payload);
        logger.info("Message: " + payload + " sent to topic: " + topic);
    }
}
