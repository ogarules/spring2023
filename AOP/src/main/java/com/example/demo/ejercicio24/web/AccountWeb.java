package com.example.demo.ejercicio24.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.ejercicio24.model.Account;
import com.example.demo.ejercicio24.service.IAccountService;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccountWeb implements IAccountWeb {

    @Autowired
    IAccountService accountService;

    @Override
    public void showAccountsFromnCustomerId(Long custonerId) {
        log.info("Controller getting account");

        var accountList = accountService.findByCustomerId(custonerId);

        accountList.stream().forEach(System.out::println);
        
    }

    @Override
    public void processFormUpdateBalance(Account account, Long amount) {
        log.info("Controller processing update balance");
        accountService.updateBalance(account, amount);
    }

    @Override
    public void processFormUpdateDescription(Account account) {
        log.info("Controller updating description");
        accountService.updateDescription(account);
    }
    
}
