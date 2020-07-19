package com.kapx.sprintboot.kafka.producer;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

@SpringBootTest
public class KafkaProducerITest {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void sendMessageToKafkaBrokers() {
        IntStream.rangeClosed(1, 10).forEach(sendMessage);
    }

    private IntConsumer sendMessage = (i) -> {
        CustomMessage message = CustomMessage.builder()
                .message("Test Message + " + i)
                .type("Kafka")
                .build();
        this.kafkaProducer.send(message);
    };
}
