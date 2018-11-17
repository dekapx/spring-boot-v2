package com.kapx.sprintboot.kafka.producer;

import com.kapx.sprintboot.kafka.model.CustomMessage;

public interface KafkaProducer {
    void send(CustomMessage payload);
}
