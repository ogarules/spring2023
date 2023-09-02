package com.example.demo.ejercicio2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldTraditional {
    
    @Test
    public void traditionalTest(){
        log.info("Initializing objects manually...");

        HelloWorld helloWorld = new HelloWorld("Hello world following tradition");

        Assert.assertEquals("Hello world following tradition", helloWorld.getMensaje());

    }

    @Test
    public void factoryTest(){
        log.info("Initializing objects with factory");
        String path = "spring/ejercicio2/beans.xml";
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(path));

        HelloWorld helloWorldProps = (HelloWorld)factory.getBean("helloWorldProperties");
        HelloWorld helloWorldConst = (HelloWorld)factory.getBean("helloWorldConstructor");

        Assert.assertEquals("Hello world from properties", helloWorldProps.getMensaje());
        Assert.assertEquals("Hello world from constructor", helloWorldConst.getMensaje());

        HelloWorld helloWorldProps2 = (HelloWorld)factory.getBean("helloWorldProperties");
        helloWorldProps2.setMensaje("Was aaaap!!!");
        
        Assert.assertEquals(helloWorldProps.getMensaje(), helloWorldProps2.getMensaje());
    }
}
