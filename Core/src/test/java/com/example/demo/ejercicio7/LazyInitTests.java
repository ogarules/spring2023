package com.example.demo.ejercicio7;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyInitTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio7/beans.xml");
    }

    @Test
    public void lazyInitTest(){
        log.info("Probando lazy init");

        Car car = context.getBean(Car.class);

        log.info("Asserting....");
        Assert.assertNotNull(car);
    }
}
