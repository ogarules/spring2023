package com.example.demo.ejercicio27.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SPRING_DATA_CUSTOMER_TBL")
@ToString(exclude = "accounts")
@EqualsAndHashCode(exclude = "accounts")
public class Customer {
    
    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Account> accounts = new ArrayList<>();
}
