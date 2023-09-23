package com.example.demo.ejerciciob;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanFactoryPostProcessorTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejerciciob/beans.xml");
    }

    @Test
    public void factoryTest(){
        log.info("Testing bean factory post processor");

        Ant ant = (Ant) context.getBean("antbean");

        assertNotNull(ant);
        assertEquals("red", ant.getColor());
    }
}
