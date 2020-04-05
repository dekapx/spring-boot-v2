package com.dekapx.springboot.batch.reader;

import com.dekapx.springboot.batch.model.AbstractBaseEntity;
import com.dekapx.springboot.batch.model.BatchEntityWrapper;
import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("contactItemReader")
public class ContactItemReader implements ItemReader<BatchEntityWrapper<AbstractBaseEntity>>, InitializingBean {
    private List<Contact> contacts;

    @Autowired
    private ContactServiceAdapter contactServiceAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-------------- ContactItemReader.afterPropertiesSet --------------");
        this.contacts = this.contactServiceAdapter.loadPendingContacts();
    }

    @Override
    public BatchEntityWrapper<AbstractBaseEntity> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("-------------- ContactItemReader.read --------------");
        if (!this.contacts.isEmpty()) {
            return prepareWrapper(this.contacts.remove(0));
        } else {
            return null;
        }
    }

    private BatchEntityWrapper<AbstractBaseEntity> prepareWrapper(final Contact contact) {
        return BatchEntityWrapper
                .builder()
                .entity(contact)
                .statusKey("STATUS.1")
                .build();
    }
}
