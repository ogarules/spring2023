package com.example.demo.ejercicio28.component;

import org.springframework.stereotype.Component;

@Component
public class BeanComponent {
    public String sayHello(String nanme){
        return "Hello " + nanme + " !!!!!!!!!";
    }
}
