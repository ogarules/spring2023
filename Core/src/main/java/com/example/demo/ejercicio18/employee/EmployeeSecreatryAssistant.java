package com.example.demo.ejercicio18.employee;

import javax.inject.Named;

import com.example.demo.ejercicio18.Employee;

@Named("secreatryAssistantEmployee")
public class EmployeeSecreatryAssistant extends Employee {
    public EmployeeSecreatryAssistant(){
        this.setName("Secretaryassistant");
        this.setRfc("GALO123");
    }
}
