package com.example.demo.ejercicio16;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourcesPreDestroy {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio16/beans.xml");
    }

    @Test
    public void testPostControcutPredestroyResources(){
        log.info("Testing annotations postcontrct predestroy and resources");

        Student student = context.getBean(Student.class);

        assertEquals("OGA", student.getName());
        assertEquals("enrollment", student.getEnrollment());
        assertEquals("math subject", student.getMath().getName());
        assertEquals("other subject", student.getSubject().getName());
    }
}
