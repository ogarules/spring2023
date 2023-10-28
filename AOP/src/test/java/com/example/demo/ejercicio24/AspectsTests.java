package com.example.demo.ejercicio24;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio24.model.Account;
import com.example.demo.ejercicio24.web.IAccountWeb;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AspectsTests {
    
    @Autowired
    IAccountWeb controller;

    @Test
    public void aspectTest(){
        log.info("Testing aspects....");

        controller.processFormUpdateBalance(Account.builder().accountDescription("Cuenta oga").balance(new BigDecimal(100)).build(), 200L);
        
    }
}
