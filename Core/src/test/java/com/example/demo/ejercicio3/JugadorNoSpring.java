package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.codec.multipart.Part;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorNoSpring {
    
    @Test
    public void noSpringTest(){
        log.info("Testing traditional...");

        Evento evento = new Evento("La gran final");
        Torneo torneo = new Torneo("Super campeones", evento);
        Partido partido = new Partido("Newpi vs furama");

        JugadorFutbol futbol = new JugadorFutbol("Oliver Atto", torneo, partido);

        Assert.assertEquals("La gran final", futbol.getTorneo().getEvento().getNombre());
    }
}
