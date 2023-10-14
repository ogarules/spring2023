package com.example.demo.ejercicio21.methodReplacement;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunReplacer implements MethodReplacer {
    
    @Override
    public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        int otherMilies = 200;

        SportCar car = (SportCar)arg0;
        log.info("Replaced: {} running {}", car.getModel(), otherMilies);

        return otherMilies;
    }

    
    
}
