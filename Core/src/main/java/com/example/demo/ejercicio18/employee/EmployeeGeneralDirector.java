package com.example.demo.ejercicio18.employee;

import javax.inject.Named;

import com.example.demo.ejercicio18.Employee;

@Named("generalDirectorEmployee")
public class EmployeeGeneralDirector extends Employee {
    public EmployeeGeneralDirector(){
        this.setName("General Director");
        this.setRfc("GALO123");
    }
}
