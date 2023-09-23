package com.example.demo.tarea2;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NamespacesTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/tarea2/beans.xml");
    }

    @Test
    public void namespacesTest(){
        log.info("Testing namespaces...");

        Agenda agenda = (Agenda)context.getBean("agendaFamiliar");

        assertTrue(agenda.getNumeros().size() > 0);
    }
}
