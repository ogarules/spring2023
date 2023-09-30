package com.example.demo.ejercicio17;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentScan {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/ejercicio17/beans.xml");
    }

    @Test
    public void componentScanTest(){
        log.info("Testing omponent scan");

        IControllerClass controllerClass = context.getBean(IControllerClass.class);
        IRestControllerClass restControllerClass = context.getBean(IRestControllerClass.class);
        IServiceClass serviceClass = context.getBean(IServiceClass.class);
        IComponentClass componentClassClass = context.getBean(IComponentClass.class);
        IRepositoryClass repsitoryClass = context.getBean(IRepositoryClass.class);

        assertEquals("My component class", componentClassClass.getComponentClassName());
        assertEquals("My repository class", repsitoryClass.getRepositoryClassName());
        assertEquals("My service class", serviceClass.getServiceClassName());
        assertEquals("My controller class", controllerClass.getControllerClassName());
        assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
    }
}
