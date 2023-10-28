package com.example.demo.ejercicio25.domain;

import java.math.BigDecimal;

import com.example.demo.ejercicio25.models.CustomDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"customer"})
public class Account {
    private Long id;
    private Customer customer;
    private String accountNumber;
    private BigDecimal balance;
    private CustomDate createDate;
    
}
