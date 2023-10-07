package com.example.demo.ejercicio18.team;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;
import com.example.demo.ejercicio18.Team;

@Named("teamx")
@Singleton
public class TeamX extends Team {
    
    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.ARCHITECT)
    public void setArchitect(Employee architect){
        super.setArchitect(architect);
    }

    @Override
    @Resource(name = "teamxEmployees")
    public void setEmployees(List<String> employees){
        super.setEmployees(employees);
    }

    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.PROGRAMMER)
    public void setProgrammer(Employee programmer){
        super.setProgrammer(programmer);
    }

    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.TESTER)
    public void setTester(Employee tester){
        super.setTester(tester);
    }
}
