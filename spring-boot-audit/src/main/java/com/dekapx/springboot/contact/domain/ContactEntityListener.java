package com.dekapx.springboot.contact.domain;

import com.dekapx.springboot.contact.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.PrePersist;

@Slf4j
public class ContactEntityListener {
    @Autowired
    @Qualifier("statusRepository")
    private StatusRepository statusRepository;

    @PrePersist
    public void prePersist(ContactEntity contactEntity) {
        log.info("prePersist...................");
        ContactApplicationContextAware.injectDependency(this);
        contactEntity.setStatus(getStatus());
    }

    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    private StatusEntity getStatus() {
        return statusRepository.findByStatus("PENDING_NEW_AUTHORISED");
    }
}
