package com.example.demo.ejercicio8;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoriesTests {
    public static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio8/beans.xml");
    }

    @Test
    public void factoryMethodTest(){
        log.info("Probando factory method");

        Student student = context.getBean("studentByFactiryMethod", Student.class);

        assertEquals("oga", student.getName());
    }

    @Test
    public void factoryClassTest(){
        log.info("Probando factory class");

        Student student = context.getBean("studentByFactoryClass", Student.class);

        assertEquals("oga", student.getName());
    }
}
