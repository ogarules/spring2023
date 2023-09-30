package com.example.demo.ejercicio15;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.ejercicio15.property.Reporter;
import com.example.demo.ejercicio15.setter.Journalist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationSetter {
     private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-setter.xml");
    }

    @Test
    public void testBySetter(){
        log.info("Testing by setter");

        Journalist journalist = context.getBean(Journalist.class);

        assertEquals("Jordan Peterson", journalist.getName());
        assertEquals("GALO", journalist.getRfc());
        assertEquals(new Integer(123), journalist.getAge());
        assertEquals("scribe", journalist.getNotebook().getBrand());
        assertEquals("professional", journalist.getNotebook().getSize());
    }
}
