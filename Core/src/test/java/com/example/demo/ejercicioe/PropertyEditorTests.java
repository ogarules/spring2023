package com.example.demo.ejercicioe;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyEditorTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("spring/ejercicioe/beans.xml");
    }

    @Test
    public void propertyEditorTest(){
        log.info("Testing property editor...");

        Client client = context.getBean(Client.class);

        assertEquals("1111-2222-3333-4444", client.getCard().getRawCardNumber());
        
    }
}
