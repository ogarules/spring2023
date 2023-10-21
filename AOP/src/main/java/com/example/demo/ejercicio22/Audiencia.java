package com.example.demo.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.ColorWriter;
import com.example.demo.util.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("audienciaBean")
public class Audiencia implements IAudiencia {
    
    @Autowired
    private IColorWriter colorWriter;

    public void print(Color color, String message){
        log.info(this.colorWriter.getColoredMessage(color, message));
    }

    public String getInfo(){
        return "[Audiencia] La audiencia ";
    }

    @Override
    public void aplaudir() {
       print(Color.BLUE, getInfo() + " aplaude CLAP CLAP !!!");
    }

    @Override
    public void abuchear() {
        print(Color.RED, getInfo() + " abuchea BUUUUUU !!!");
    }

    @Override
    public void sePoneDePie() {
        print(Color.YELLOW, getInfo() + " se pone de pie !!!");
    }

    @Override
    public void seSienta() {
        print(Color.WHITE, getInfo() + " se sienta");
    }

    @Override
    public void gritarGol() {
        print(Color.GREEN, getInfo() + " grita GOOOOOOOL !!!!");
    }

    @Override
    public void gritarOle() {
        print(Color.MAGENTA, getInfo() + " grita OLEEEEEE !!!!");
    }

    @Override
    public Object sePoneDeNervios(ProceedingJoinPoint pjp) throws Throwable {
        print(Color.CYAN, getInfo() + " se pone de nervios");

        Object result = pjp.proceed();
        abuchear();
        abuchear();
        aplaudir();
        aplaudir();

        print(Color.CYAN, getInfo() + " se deja de poner de nervios !!!!!");

        return result;
    }
}
