package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository repository;
    @Autowired
    private SyncService syncService;

    @Override
    public Contact findById(final Long id) {
        log.info("Find and return contact");
        return Contact.builder().id(1L).firstName("Test").lastName("Person").build();
    }

    @Override
    public Contact save(Contact contact) {
        Contact savedContact = this.repository.save(contact);
        if (Objects.nonNull(savedContact)) {
            executeCompletableFuture(buildCompletableFuture());
        }
        return savedContact;
    }

    private CompletableFuture<Void> buildCompletableFuture() {
        return CompletableFuture.runAsync(() -> {
            this.syncService.sendEvent("Test Event");
        }).orTimeout(4, TimeUnit.SECONDS).whenComplete((input, exception) -> {
            if (Objects.nonNull(exception)) {
                log.error("Service not available...");
            }
        });
    }

    private void executeCompletableFuture(CompletableFuture<Void> future) {
        try {
            future.get();
        } catch (Exception e) {
            log.error("Exception...");
        }
    }
}
