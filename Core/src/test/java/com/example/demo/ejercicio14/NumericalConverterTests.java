package com.example.demo.ejercicio14;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericalConverterTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio14/beans.xml");
    }

    @Test
    public void converterTest(){
        log.info("TEsting converter autowiring...");

        NumericalConverter converter = context.getBean(NumericalConverter.class);

        assertEquals("NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100", converter.convert("9999999,00", true));
    }
}
