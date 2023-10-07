package com.example.demo.ejercicio18.employee;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;

@Named
@Singleton
@EmployeeQualifier(employeeType = EmployeeType.TESTER)
public class EmployeeTester extends Employee {
    public EmployeeTester(){
        this.setName("Tester");
        this.setRfc("GALO123");
    }
}
