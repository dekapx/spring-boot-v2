package com.dekapx.springboot.batch.reader;

import com.dekapx.springboot.batch.model.AbstractBaseEntity;
import com.dekapx.springboot.batch.model.BatchEntityWrapper;
import com.dekapx.springboot.batch.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@StepScope
@Component("contactItemReader")
public class ContactItemReader implements ItemReader<BatchEntityWrapper<AbstractBaseEntity>>, InitializingBean {
    private List<Contact> contacts;

    @Autowired
    private ContactServiceAdapter contactServiceAdapter;

    @PostConstruct
    public void init() {
        log.info("-------------- ContactItemReader.init() --------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-------------- ContactItemReader.afterPropertiesSet --------------");
        this.contacts = this.contactServiceAdapter.loadPendingContacts();
    }

    @Override
    public BatchEntityWrapper<AbstractBaseEntity> read() {
        return (!this.contacts.isEmpty()) ? prepareWrapper(this.contacts.remove(0)) : null;
    }

    private BatchEntityWrapper<AbstractBaseEntity> prepareWrapper(final Contact contact) {
        return BatchEntityWrapper
                .builder()
                .entity(contact)
                .statusKey("STATUS.1")
                .build();
    }
}
