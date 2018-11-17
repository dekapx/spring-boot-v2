package com.kapx.sprintboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {
    void onMessage(ConsumerRecord<?, ?> consumerRecord);
}
