package com.example.demo.ejercicio18.employee;

import javax.inject.Named;

import com.example.demo.ejercicio18.Employee;

@Named("itDirectorEmployee")
public class EmployeeDirector extends Employee {
    public EmployeeDirector(){
        this.setName("Director");
        this.setRfc("GALO123");
    }
}
