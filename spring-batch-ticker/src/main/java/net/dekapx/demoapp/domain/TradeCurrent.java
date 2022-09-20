package net.dekapx.demoapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "trade_current")
public class TradeCurrent extends AbstractBaseEntity {
}
