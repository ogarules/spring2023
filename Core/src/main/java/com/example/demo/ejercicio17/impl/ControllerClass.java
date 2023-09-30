package com.example.demo.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.ejercicio17.IControllerClass;
import com.example.demo.ejercicio17.IServiceClass;

import lombok.Data;

@Data
@Controller
public class ControllerClass implements IControllerClass{
    
    @Autowired
    IServiceClass service;

    @Autowired
    private String controllerClassName;
}
