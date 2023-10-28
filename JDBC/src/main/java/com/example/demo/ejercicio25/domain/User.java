package com.example.demo.ejercicio25.domain;

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
public class User {
    private Long id;
    private String userName;
    private String password;
    private Customer customer;
}
