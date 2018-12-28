package com.dekapx.springboot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CONTACT_ADT")
public class ContactAuditEntity extends BaseAuditEntity {
}
