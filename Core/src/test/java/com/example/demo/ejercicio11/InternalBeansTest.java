package com.example.demo.ejercicio11;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InternalBeansTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio11/beans.xml");
    }

    @Test
    public void InternalBeansTest(){
        log.info("Testing internal beans----");

        Person person = context.getBean(Person.class);

        assertEquals("el que me cae bien", person.getAddress().getNeighbor());
    }
}
