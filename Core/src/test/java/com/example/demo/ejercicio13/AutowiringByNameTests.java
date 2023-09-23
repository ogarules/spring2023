package com.example.demo.ejercicio13;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiringByNameTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context= new ClassPathXmlApplicationContext("spring/ejercicio13/beans-name.xml");
    }

    @Test
    public void autowireTest(){
        log.info("Testing autowire by name...");

        Car car = context.getBean(Car.class);

        assertNotNull(car);
    }
}
