package com.dekapx.springboot.contact.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CONTACT")
public class ContactEntity extends BaseEntity {
    private static final Logger LOGGER  = LoggerFactory.getLogger(ContactEntity.class);

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

}
