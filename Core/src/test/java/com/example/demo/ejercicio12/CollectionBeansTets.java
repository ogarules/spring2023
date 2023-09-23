package com.example.demo.ejercicio12;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionBeansTets {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeCLass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio12/beans.xml");
    }

    @Test
    public void collectionBeanTest(){
        log.info("Testing collection bean configuration");

        AddressBook book = context.getBean("addressBookBean", AddressBook.class);

        assertTrue(book.getAddresses().size() > 0);
    }
}
