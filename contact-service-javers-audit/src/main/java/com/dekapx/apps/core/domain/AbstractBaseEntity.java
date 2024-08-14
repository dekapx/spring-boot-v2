package com.dekapx.apps.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity<U> implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Long id;

    @DiffIgnore
    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = true)
    protected Date createdDate;

    @DiffIgnore
    @CreatedBy
    @Column(name = "CREATED_BY")
    protected U createdBy;

    @DiffIgnore
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false, updatable = true)
    protected Date lastModifiedDate;

    @DiffIgnore
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    protected U lastModifiedBy;
}
