package com.example.demo.ejercicio15;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.ejercicio15.property.Reporter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationProperties {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-property.xml");
    }

    @Test
    public void testByProperties(){
        log.info("Testing by property");

        Reporter reporter = context.getBean(Reporter.class);

        assertEquals("Jordan Peterson", reporter.getName());
        assertEquals(new Integer(123), reporter.getAge());
        assertEquals("scribe", reporter.getBooklet().getBrand());
        assertEquals("professional", reporter.getBooklet().getSize());
    }
}
