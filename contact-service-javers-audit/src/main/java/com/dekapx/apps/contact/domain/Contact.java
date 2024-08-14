package com.dekapx.apps.contact.domain;

import com.dekapx.apps.core.domain.AbstractBaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "contacts")
public class Contact extends AbstractBaseEntity<String> implements Serializable {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;
}
