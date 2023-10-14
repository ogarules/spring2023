package com.example.demo.ejercicio21.methodInjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public abstract class SingletonBEan {
    
    @Value("3")
    private Integer iterations;

    public String process(String data){
        return getProcessor().processData(data, iterations);
    }

    @Lookup("stringProcessor")
    public abstract IProcessor getProcessor();
}
