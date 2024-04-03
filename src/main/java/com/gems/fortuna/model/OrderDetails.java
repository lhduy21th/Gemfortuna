package com.gems.fortuna.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.*;

@Data
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String client;
    private BigDecimal total = BigDecimal.ZERO;
    @CreationTimestamp
    private Timestamp date;

    @ElementCollection(fetch = FetchType.LAZY)
    private Map<Long, Integer> products = new LinkedHashMap<>();

}
