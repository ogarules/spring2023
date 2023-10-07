package com.example.demo.ejercicio18.employee;

import javax.inject.Named;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.ManagerEmployeeQualifier;

@Named
@ManagerEmployeeQualifier
public class EmployeeManager extends Employee {
    public EmployeeManager(){
        this.setName("Manager");
        this.setRfc("GALO123");
    }
}
