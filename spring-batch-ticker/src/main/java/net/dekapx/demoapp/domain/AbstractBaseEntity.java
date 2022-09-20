package net.dekapx.demoapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "trade_id")
    private String tradeId;

    @Column(name = "trade_name")
    private String tradeName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "trans_date")
    private Date transactionDate;
}
