package com.kapx.sprintboot.kafka.consumer;

import com.kapx.sprintboot.kafka.model.CustomMessage;

public interface KafkaConsumer {
    void receive(CustomMessage greeting);
}
