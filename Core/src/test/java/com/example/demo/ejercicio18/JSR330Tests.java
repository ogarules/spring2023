package com.example.demo.ejercicio18;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ejercicio18/beans.xml")
public class JSR330Tests {
    
    @Inject
    private Corporation corporation;

    @Test
    public void annotationTest(){
        log.info("Testing JSR330 annotattions");

        assertNotNull(corporation);
    }
}
