package com.example.demo.ejercicio22;

public interface IJugador {
    void ejecutarPase();
    void cometerFalta();
    void esExpulsado();
    void tirarAGol(boolean gol) throws Throwable;
    void cobrarPenal(boolean gol) throws Throwable;
}
