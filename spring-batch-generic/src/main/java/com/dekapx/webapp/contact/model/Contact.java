package com.dekapx.webapp.contact.model;

import com.dekapx.webapp.appcore.model.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contacts")
public class Contact extends AbstractBaseEntity<String> {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    protected Status status;
}
