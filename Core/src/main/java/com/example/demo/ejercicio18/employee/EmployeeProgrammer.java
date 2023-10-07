package com.example.demo.ejercicio18.employee;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;

@Named
@Singleton
@EmployeeQualifier(employeeType = EmployeeType.PROGRAMMER)
public class EmployeeProgrammer extends Employee {
    public EmployeeProgrammer(){
        this.setName("Programmer");
        this.setRfc("GALO123");
    }
}
