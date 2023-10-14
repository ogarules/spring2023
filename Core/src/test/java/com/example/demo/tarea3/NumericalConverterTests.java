package com.example.demo.tarea3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.tarea3.ApplicationConfig;
import com.example.demo.tarea3.NumericalConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class NumericalConverterTests {
    
    @Autowired
    NumericalConverter converter;

    @Test
    public void numericalConverterTest(){
        log.info("Testing with spanish");

        String convertSpanish = converter.convert("9999999,00", true, "esp");
        String convertEnglish = converter.convert("9999999,00", true, "eng");
        log.info(convertEnglish);
        log.info(convertSpanish);

        assertEquals("NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100", convertSpanish);
        assertEquals("NINE MILLIONS NINE HUNDRED NINETY  NINE THOUSEND NINE HUNDRED NINETY  NINE DOLLARS 00/100", convertEnglish);
    }
}
