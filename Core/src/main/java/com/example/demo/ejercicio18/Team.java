package com.example.demo.ejercicio18;

import java.util.List;

import lombok.Data;

@Data
public class Team {
    private List<String> employees;

    private Employee architect;
    private Employee programmer;
    private Employee tester;
}
