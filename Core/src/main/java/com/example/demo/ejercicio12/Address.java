package com.example.demo.ejercicio12;

import lombok.Data;

@Data
public class Address {
    private String street;
    private int internalNumber;
    private int externalNumber;
    private String neighbor;
}
