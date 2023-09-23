package com.example.demo.ejercicioa;

import org.springframework.context.SmartLifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmartLyfeCycleDemo implements SmartLifecycle {
    
    private boolean isRunning = false;

    @Override
    public boolean isRunning() {
        log.info("Verificando que se este ejecutando el smartlifecycle.....");
        return isRunning;
    }

    @Override
    public void start() {
        log.info("Smart life cycle starting....");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("Smart life cylcle stoping...");

        isRunning = false;
    }
}
