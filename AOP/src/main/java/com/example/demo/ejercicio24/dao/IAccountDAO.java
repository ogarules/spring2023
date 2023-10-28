package com.example.demo.ejercicio24.dao;

import com.example.demo.ejercicio24.model.Account;
import java.util.List;

public interface IAccountDAO {
    List<Account> findByCustomerId(Long customerId);
    void updateBalance(Account account, Long amount);
    void updateDescription(Account account);
}
