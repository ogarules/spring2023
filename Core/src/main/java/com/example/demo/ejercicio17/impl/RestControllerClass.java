package com.example.demo.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicio17.IRestControllerClass;
import com.example.demo.ejercicio17.IServiceClass;

import lombok.Data;

@Data
@RestController
public class RestControllerClass implements IRestControllerClass{
    
    @Autowired
    IServiceClass service;

    @Autowired
    String restControllerClassName;
}
