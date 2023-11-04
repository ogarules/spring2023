package com.example.demo.ejercicio26;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio26.domain.BusinessObject;
import com.example.demo.ejercicio26.service.ITransactionalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnnotatopmTransactionTests {
    
    @Autowired
    ITransactionalService service;

    @Test
    public void trnasactionTest(){
        log.info("Testing xml transaction configuration");

        BusinessObject bo = null;

        bo = service.getBusinessObject(1L);

        log.info("Inserting BO");

        try {
            service.insertBusinessObject(bo);
        } catch (Exception e) {
            log.error("Insert error {}", e.getMessage());
        }

        log.info("Updating bo");

        try {
            service.updateBusinessObject(bo);
        } catch (Exception e) {
            log.error("Update error {}", e.getMessage());
        }

        log.info("Deleting BO");

        service.deleteBusinessObject(bo);
    }
}
