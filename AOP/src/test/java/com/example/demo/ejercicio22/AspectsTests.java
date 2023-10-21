package com.example.demo.ejercicio22;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio22/beans-aop.xml"})
public class AspectsTests {
    
    @Value("#{jugadorBean}")
    private IJugador jugador;

    @Test
    public void aspectsTest(){
        log.info("Testing flow with aspects...");

        jugador.ejecutarPase();

        log.info("-------------------------");

        jugador.ejecutarPase();

        log.info("-------------------------");

        jugador.cometerFalta();

        log.info("-------------------------");

        jugador.esExpulsado();

        log.info("-------------------------");

        try {
            jugador.cobrarPenal(false);    
        } catch (Throwable e) {
            log.error("{}", e.getMessage());
        }

        log.info("-------------------------");

        try {
            jugador.tirarAGol(false);    
        } catch (Throwable e) {
            log.error("{}", e.getMessage());
        }

        log.info("-------------------------");

        try {
            jugador.tirarAGol(true);    
        } catch (Throwable e) {
            log.error("{}", e.getMessage());
        }
    }

}
