package com.example.demo.ejercicio26.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ejercicio26.domain.BusinessObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class TransactionalService implements ITransactionalService {
    
    @Transactional(readOnly = true)
    @Override
    public BusinessObject getBusinessObject(Long id) {
        log.info("Getting business object");
        return BusinessObject.builder().id(id).data("TEST").build();
    }

    @Override
    public void insertBusinessObject(BusinessObject businessObject) {
        log.info("Inserting  business object");
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateBusinessObject(BusinessObject businessObject) {
        log.info("Updating business object");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteBusinessObject(BusinessObject businessObject) {
        log.info("Deleting business object");
    }
    
}
