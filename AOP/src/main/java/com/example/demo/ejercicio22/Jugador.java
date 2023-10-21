package com.example.demo.ejercicio22;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("jugadorBean")
public class Jugador implements IJugador {
    
    @Value("oga")
    private String nombre;

    @Value("123")
    private String numero;

    public void print(String message){
        log.info(message);
    }

    public String getInfo(){
        return "[Jugador] El jugador " + nombre + " [" + numero + "]";
    }

    @Override
    public void ejecutarPase() {
        print(getInfo() + " pasa el balon");
    }

    @Override
    public void cometerFalta() {
        print(getInfo() + " cometio una falta");
    }

    @Override
    public void esExpulsado() {
        print(getInfo() + " es expulsado");
    }

    @Override
    public void tirarAGol(boolean gol) throws Throwable {
        print(getInfo() + " se prepara para tirar a gol");

        if(gol){
            print(getInfo() + " anoto un golazo");
        }
        else{
            throw new Exception(getInfo() + " fallo un tiro y por eso cobran");
        }
    }

    @Override
    public void cobrarPenal(boolean gol) throws Throwable {
        print(getInfo() + " se prepara para cobrar un penal");

        if(gol){
            print(getInfo() + " anoto el penal");
        }
        else{
            throw new Exception(getInfo() + " fallo el penal");
        }
    }

    
}
