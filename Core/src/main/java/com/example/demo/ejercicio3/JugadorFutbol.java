package com.example.demo.ejercicio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class JugadorFutbol implements IJugador {
    private String nombre;
    private Torneo torneo;
    private Partido partido;

    @Override
    public void saludar(){
        log.info("Jugador de jutbol saludando....");
    }
}
