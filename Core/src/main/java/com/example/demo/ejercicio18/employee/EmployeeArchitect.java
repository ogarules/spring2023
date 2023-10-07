package com.example.demo.ejercicio18.employee;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;

@Named
@Singleton
@EmployeeQualifier(employeeType = EmployeeType.ARCHITECT)
public class EmployeeArchitect extends Employee {
    
    public EmployeeArchitect(){
        this.setName("Architect");
        this.setRfc("GALO123");
    }
}
