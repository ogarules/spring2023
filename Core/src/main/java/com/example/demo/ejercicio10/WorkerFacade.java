package com.example.demo.ejercicio10;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class WorkerFacade implements IWorker {
    private String name;
    private int age;

    private IWorker originalWorker;

    public WorkerFacade(){
        log.info("WorkerFacade - Construction facade...");
    }

    public void setOriginalWorker(IWorker orginalWorker){
        this.originalWorker = orginalWorker;

        age = orginalWorker.getAge();
        name = orginalWorker.getName();
    }

    @Override
    public void init() {
        log.info("Initializing facade worker...");
    }

    @Override
    public void destroy() {
        log.info("Killing facade worker....");
    }

    @Override
    public void showInfo() {
        log.info("Facade worker info name {}, age {}", name, age);
        this.originalWorker.showInfo();
    }

    
}
