package com.dekapx.springboot.contact.event.listener;

import com.dekapx.springboot.contact.event.model.ContactApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContactAppEventListener {
    @EventListener
    public void onApplicationEvent(final ContactApplicationEvent appEvent) {
        log.info("Event received... {}", appEvent.getEvent());
    }
}
