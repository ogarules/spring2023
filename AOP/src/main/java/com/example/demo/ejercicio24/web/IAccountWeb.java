package com.example.demo.ejercicio24.web;

import com.example.demo.ejercicio24.model.Account;

public interface IAccountWeb {
    void showAccountsFromnCustomerId(Long custonerId);
    void processFormUpdateBalance(Account account, Long amount);
    void processFormUpdateDescription(Account account);
    
}
