package com.dekapx.springboot.batch.processor;

import com.dekapx.springboot.batch.model.BatchEntityWrapper;
import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.model.Status;
import com.dekapx.springboot.batch.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("contactItemProcessor")
public class ContactItemProcessor implements ItemProcessor<BatchEntityWrapper<Contact>, Contact> {
    @Autowired
    private StatusService statusService;

    @BeforeStep
    public void beforeStep() {
        log.info("-------------- ContactItemProcessor.beforeStep --------------");
    }

    @Override
    public Contact process(BatchEntityWrapper<Contact> batchEntityWrapper) {
        final Contact contact = batchEntityWrapper.getEntity();
        final String statusKey = batchEntityWrapper.getStatusKey();
        final Status status = this.statusService.findByStatusKey(statusKey);
        contact.setStatus(status);
        log.info(contact.toString());
        return contact;
    }

    @AfterStep
    public void afterStep() {
        log.info("-------------- ContactItemProcessor.afterStep --------------");
    }
}