package com.example.demo.ejercicio27.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name="SPRING_DATA_ACCOUNT_TBL")
@ToString(exclude = "customer")
@EqualsAndHashCode(exclude="customer")
public class Account {
    
    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FK_CUSTOMER_ID")
    private Customer customer;
}
