package com.example.demo.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.ejercicio17.IComponentClass;
import com.example.demo.ejercicio17.IRepositoryClass;

import lombok.Data;

@Data
@Component
public class ComponentClass implements IComponentClass {
    
    @Autowired
    IRepositoryClass repository;

    @Autowired
    private String componentClassName;
}
