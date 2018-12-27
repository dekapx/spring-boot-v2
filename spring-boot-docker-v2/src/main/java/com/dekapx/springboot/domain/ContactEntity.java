package com.dekapx.springboot.domain;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.Date;

@Log
@Data
@Entity
@Table(name = "CONTACTS")
@EntityListeners(AuditingEntityListener.class)
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

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

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private StatusEntity status;

    @PrePersist
    public void onPrePersist() {
        log.info("onPrePersist..........................");
    }

    @PreUpdate
    public void onPreUpdate() {
        log.info("onPreUpdate..........................");
    }

    @PreRemove
    public void onPreRemove() {
        log.info("onPreRemove..........................");
    }
}
