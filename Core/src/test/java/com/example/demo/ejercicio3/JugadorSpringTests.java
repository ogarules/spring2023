package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorSpringTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        String path = "spring/ejercicio3/beans.xml";
        context = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void springTest(){
        log.info("Testing with spring");

        IJugador jugador = (IJugador) context.getBean("jugadorFutbolBean");

        Assert.assertEquals("Oliver atto", jugador.getNombre());
        Assert.assertEquals("La gran final", jugador.getTorneo().getNombre());
        Assert.assertEquals("newpi vs furama", jugador.getPartido().getNombre());
        Assert.assertEquals("Super campeones", jugador.getTorneo().getEvento().getNombre());

        jugador = (IJugador) context.getBean("jugadorTenisBean");
        Assert.assertEquals("Tennis atto", jugador.getNombre());

        jugador = (IJugador) context.getBean("jugadorBeisbolBean");
        Assert.assertEquals("Beisbol atto", jugador.getNombre());
    }
}
