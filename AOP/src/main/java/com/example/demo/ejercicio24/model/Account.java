package com.example.demo.ejercicio24.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
    private String accountNumber;
    private String accountDescription;
    private BigDecimal balance;
}
