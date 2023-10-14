package com.example.demo.ejercicio20;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BeanResoureLoaderAware implements ResourceLoaderAware {
    
    private ResourceLoader resourceLoader;
}
