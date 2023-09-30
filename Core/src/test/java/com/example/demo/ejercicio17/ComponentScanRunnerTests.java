package com.example.demo.ejercicio17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio17/beans.xml" })
public class ComponentScanRunnerTests {
    
    @Autowired
    IComponentClass componentClass;

    @Autowired
    IServiceClass serviceClass;

    @Autowired
    IRepositoryClass repositoryClass;

    @Autowired
    IControllerClass controllerClass;

    @Autowired
    IRestControllerClass restControllerClass;

    @Test
    public void conponentScanTest(){
        log.info("TEsting component scan with runner...");

        assertEquals("My component class", componentClass.getComponentClassName());
        assertEquals("My repository class", repositoryClass.getRepositoryClassName());
        assertEquals("My service class", serviceClass.getServiceClassName());
        assertEquals("My controller class", controllerClass.getControllerClassName());
        assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
    }
}
