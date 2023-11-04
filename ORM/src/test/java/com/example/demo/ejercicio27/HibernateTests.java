package com.example.demo.ejercicio27;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio27.dao.IAccountDAO;
import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.Account;
import com.example.demo.ejercicio27.domain.Customer;
import com.example.demo.ejercicio27.domain.User;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio27/spring.xml"})
@ActiveProfiles("h2-in-memory")
public class HibernateTests {
    
    @Autowired
    IUserDAO userDAO;

    @Autowired
    ICustomerDAO customerDao;

    @Autowired
    IAccountDAO accountDAO;

    @Test
    public void userDaoTest(){
        log.info("testing user dao...");

        User user = new User();
        user.setUsername("oga");
        user.setPassword("123");

        Customer customer = new Customer();
        customer.setLastName("oga");
        customer.setName("Oda");
        customer.setUser(user);

        user.setCustomer(customer);

        userDAO.insert(user);

        User userDB = userDAO.findById(user.getId());
        Customer custDb = customerDao.findById(customer.getId());

        assertEquals(user.getId(), userDB.getId());

        Account account = new Account();
        account.setAccountNumber("123");
        account.setBalance(new BigDecimal(100));
        account.setCreatedDate(new Date());

        custDb.getAccounts().add(account);

        customerDao.update(custDb);

        var accounts = accountDAO.findAll();

        assertEquals(2, accounts.size());
    }
}
