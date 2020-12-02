package com.dekapx.springboot.contact.domain;

import com.dekapx.springboot.core.domain.AbstractBaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@DynamicUpdate
@Entity
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

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Address address;
}
