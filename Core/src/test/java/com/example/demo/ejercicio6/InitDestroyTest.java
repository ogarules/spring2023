package com.example.demo.ejercicio6;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitDestroyTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio6/beans.xml");
    }

    @Test
    public void initDestroyTest(){
        log.info("Probando metodos init y destroy");

        DatabaseConnection conn = context.getBean("dbConnectionBean", DatabaseConnection.class);

        assertNotNull(conn);

        log.info("CCerrando contexto...");

        ((AbstractApplicationContext)context).close();

        log.info("Contexto cerrado");
    }
}
