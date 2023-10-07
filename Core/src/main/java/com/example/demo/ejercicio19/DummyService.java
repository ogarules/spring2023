package com.example.demo.ejercicio19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DummyService {
    private DummyRepository repository;

    public String executeService(){
        log.info("Executing service...");
        
        return this.repository.getData();
    }
}
