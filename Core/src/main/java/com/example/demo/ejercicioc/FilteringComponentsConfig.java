package com.example.demo.ejercicioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Repository;

import com.example.demo.ejercicioc.services.ServiceA;

@Configuration
@ComponentScan(basePackages = { "com.example.demo.ejercicioc" },
               excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, classes = Repository.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ServiceA.class)
               })
public class FilteringComponentsConfig {
    
}
