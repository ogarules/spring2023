package com.example.demo.ejercicioa;

import org.springframework.context.Lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifeCycleDemo implements Lifecycle {
    private boolean isRunning = false;

    @Override
    public boolean isRunning() {
        log.info("Verificando que se este ejecutando .....");
        return isRunning;
    }

    @Override
    public void start() {
        log.info("Starting lifecycle demo...");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("Stoping lifeCycle demo...");
        isRunning = false;
    }
}
