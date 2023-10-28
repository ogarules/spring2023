package com.example.demo.ejercicio24.dao;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.ejercicio24.model.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AccountDAO implements IAccountDAO {

    @Override
    public List<Account> findByCustomerId(Long customerId) {
        log.info("Finding account for customer {}", customerId);

        List<Account> result = new ArrayList<>();
        result.add(Account.builder().accountNumber("01")
                                    .accountDescription("Acc 1")
                                    .build());

        return result;
    }

    @Override
    public void updateBalance(Account account, Long amount) {
        log.info("Updating balance");
        account.setBalance(new BigDecimal(amount));
    }

    @Override
    public void updateDescription(Account account) {
        log.info("Updating description");
    }
    
}
