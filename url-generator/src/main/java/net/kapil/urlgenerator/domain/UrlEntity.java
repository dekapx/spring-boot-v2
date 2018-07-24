package net.kapil.urlgenerator.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "URLS")
@Getter
@Setter
@NoArgsConstructor
public class UrlEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORIGINAL_URL", nullable = false)
    private String originalUrl;

    @Column(name = "SHORTEN_URL", nullable = false)
    private String shortenUrl;

    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
}
