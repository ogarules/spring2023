package com.example.demo.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAudiencia {
    void aplaudir();
    void abuchear();
    void sePoneDePie();
    void seSienta();
    void gritarGol();
    void gritarOle();
    Object sePoneDeNervios(ProceedingJoinPoint pjp) throws Throwable;
}
