package com.example.demo.ejercicio28.service;

import org.springframework.stereotype.Service;

@Service
public class AddService implements IAddService {

    @Override
    public Double add(Double... numbers) {
        Double result = 0D;

        if(numbers != null){
            for (Double double1 : numbers) {
                result+=double1;
            }
        }

        return result;
    }
    
}
