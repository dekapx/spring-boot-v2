package com.dekapx.springboot.event.publisher;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AppEventPublisherTest {
    @Autowired
    private AppEventPublisher appEventPublisher;

    @Test
    public void publishEvent() {
        appEventPublisher.publishCustomEvent("Test Message");
        log.info("Event send...");
    }
}
