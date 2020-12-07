package com.dekapx.springboot.event.publisher;

import com.dekapx.springboot.contact.event.model.ContactApplicationEvent;
import com.dekapx.springboot.contact.event.model.ContactCreateEvent;
import com.dekapx.springboot.contact.event.model.ContactDeleteEvent;
import com.dekapx.springboot.contact.event.model.ContactUpdateEvent;
import com.dekapx.springboot.core.event.publisher.AppEventPublisher;
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
        ContactCreateEvent createEvent = ContactCreateEvent.builder().event("Contact Created").build();
        appEventPublisher.publishEvent(new ContactApplicationEvent(this, createEvent));

        ContactUpdateEvent updateEvent = ContactUpdateEvent.builder().event("Contact Updated").build();
        appEventPublisher.publishEvent(new ContactApplicationEvent(this, updateEvent));

        ContactDeleteEvent deleteEvent = ContactDeleteEvent.builder().event("Contact Deleted").build();
        appEventPublisher.publishEvent(new ContactApplicationEvent(this, deleteEvent));
    }
}
