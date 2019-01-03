package com.dekapx.springboot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Audited
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CONTACTS")
@EntityListeners(AuditingEntityListener.class)
public class ContactEntity extends BaseEntity {
    private static final Logger LOGGER  = LoggerFactory.getLogger(ContactEntity.class);

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @PrePersist
    public void onPrePersist() {
        LOGGER.info("onPrePersist..........................");
    }

    @PreUpdate
    public void onPreUpdate() {
        LOGGER.info("onPreUpdate..........................");
    }

    @PreRemove
    public void onPreRemove() {
        LOGGER.info("onPreRemove..........................");
    }
}
