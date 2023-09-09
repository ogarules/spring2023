package com.example.demo.ejercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopesTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio5/beans.xml");
    }

    @Test
    public void singletonTest(){
        log.info("Probando scope singleton...");

        Persona persona = (Persona) context.getBean("personaSingletonBean");
        Persona persona2 = (Persona) context.getBean("personaSingletonBean");

        persona.setNombre("Ogas");

        assertEquals(persona.getNombre(), persona2.getNombre());
    }

    @Test
    public void prototypeTest(){
        log.info("Probando scope prototype...");

        Persona persona = (Persona) context.getBean("personaPrototypeBean");
        Persona persona2 = (Persona) context.getBean("personaPrototypeBean");

        persona.setNombre("Ogas");

        assertNotEquals(persona.getNombre(), persona2.getNombre());
    }

        @Test
    public void customTest(){
        log.info("Probando scope custom...");

        Persona persona = (Persona) context.getBean("personaCustomBean");
        Persona persona2 = (Persona) context.getBean("personaCustomBean");
        Persona persona3 = (Persona) context.getBean("personaCustomBean");
        Persona persona4 = (Persona) context.getBean("personaCustomBean");
        Persona persona5 = (Persona) context.getBean("personaCustomBean");
        Persona persona6 = (Persona) context.getBean("personaCustomBean");
        Persona persona7 = (Persona) context.getBean("personaCustomBean");

        persona.setNombre("Ogas");

        assertEquals(persona.getNombre(), persona2.getNombre());
        assertEquals(persona.getNombre(), persona3.getNombre());
        assertEquals(persona.getNombre(), persona4.getNombre());
        assertEquals(persona.getNombre(), persona5.getNombre());
        assertNotEquals(persona.getNombre(), persona6.getNombre());
        assertNotEquals(persona.getNombre(), persona7.getNombre());
    }
}
