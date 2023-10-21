package com.example.demo.ejercicio23;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AnnotationTests {
    @Autowired
    private IVoluntario voluntario;

    @Test
    public void beforeTest(){
        log.info("Testing before aspect...");

        voluntario.pensarEnAlgo("Quireo un gansito...");

        String pensamiento = voluntario.getPensamiento(false);

        assertEquals("Quireo un gansito...", pensamiento);
    }

    @Test
    public void aroundTest(){
        log.info("Testing around....");

        voluntario.pensarEnAlgo("Quiero un cafecito....");

        String pensamiento = voluntario.getPensamiento(true);

        assertEquals("Momento me quieres hacer trampa....", pensamiento);

    }
}
