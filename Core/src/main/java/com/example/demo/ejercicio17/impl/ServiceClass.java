package com.example.demo.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio17.IComponentClass;
import com.example.demo.ejercicio17.IServiceClass;

import lombok.Data;

@Data
@Service
public class ServiceClass implements IServiceClass{
    
    @Autowired
    IComponentClass component;

    @Autowired
    private String serviceClassName;
    
}
