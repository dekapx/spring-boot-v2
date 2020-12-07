package com.dekapx.springboot.event.publisher;

import com.dekapx.springboot.event.model.ContactCreateEvent;
import com.dekapx.springboot.event.model.ContactDeleteEvent;
import com.dekapx.springboot.event.model.ContactUpdateEvent;
import com.dekapx.springboot.event.model.DummyEvent;
import com.dekapx.springboot.event.model.TestEvent;
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
        appEventPublisher.publishEvent(ContactCreateEvent.builder().event("Contact Created").build());
        appEventPublisher.publishEvent(ContactUpdateEvent.builder().event("Contact Updated").build());
        appEventPublisher.publishEvent(ContactDeleteEvent.builder().event("Contact Deleted").build());

        appEventPublisher.publishEvent(DummyEvent.builder().message("Dummy Event").build());
        appEventPublisher.publishEvent(DummyEvent.builder().message("Test Event").build());
    }
}
