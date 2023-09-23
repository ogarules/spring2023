package com.example.demo.ejercicio10;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Worker implements IWorker {
    private String name;
    private int age;

    public Worker(){
        this.name = "El oga";
        this.age = 21;

        log.info("Constructor - Worker name {}", name);
        log.info("Constructor - Worker age {}", age);
    }

    @Override
    public void init() {
        log.info("Initializing worker....");
        log.info("init - worker name {}", name);
        name = "Otro oga";
        log.info("init - Worker name {}", name);
    }
    @Override
    public void destroy() {
        log.info("Killing worker...");
    }
    @Override
    public void showInfo() {
        log.info("Worker info - name {} , age {}", this.name, this.age);
    }


}
