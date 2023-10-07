package com.example.demo.ejercicio18.secretary;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.ejercicio18.Employee;
import com.example.demo.ejercicio18.Secretary;
import com.example.demo.ejercicio18.SecretaryAssistantQualifier;

@Named
@Singleton
@SecretaryAssistantQualifier
public class SecretaryAssistant extends Secretary {
    
    @Override
    @Inject
    @Qualifier("secreatryAssistantEmployee")
    public void setEmployee(Employee employee){
        super.setEmployee(employee);
    }
}
