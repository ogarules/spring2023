package com.example.demo.ejerciciod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.example.demo.ejerciciod"})
@PropertySource({"classpath:spring/ejerciciod/app-properties.properties"})
public class AppConfig {
    
    @Autowired
    Environment environment;

    @Bean
    public RnvironmentClass environmentClass(){
        RnvironmentClass envClass = new RnvironmentClass();
        envClass.setAge(environment.getProperty("programmer.age", Integer.class));
        envClass.setName(environment.getProperty("programmer.name"));

        return envClass;
    }
}
