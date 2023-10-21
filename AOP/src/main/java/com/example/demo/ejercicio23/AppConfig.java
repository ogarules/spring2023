package com.example.demo.ejercicio23;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.demo.ejercicio23", "com.example.demo.util"})
public class AppConfig {
    
}
