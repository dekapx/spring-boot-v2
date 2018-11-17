package com.kapx.sprintboot.kafka.producer;

public interface KafkaProducer {
    void send(String payload);
}
