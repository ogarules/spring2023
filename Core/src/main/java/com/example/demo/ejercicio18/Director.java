package com.example.demo.ejercicio18;

import lombok.Data;

@Data
public class Director implements IDirector {
    private Employee employee;
    private Budget budget = new Budget();
}
