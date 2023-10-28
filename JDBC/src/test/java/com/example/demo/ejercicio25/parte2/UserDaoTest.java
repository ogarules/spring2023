package com.example.demo.ejercicio25.parte2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio25/spring-jdbc.xml"})
@ActiveProfiles("h2-in-memory")
public class UserDaoTest {
    
    @Autowired
    IUserDAO userDao;

    @Test
    public void userDAOInsertTest(){
        log.info("User dao inserting test");

        User user = new User();
        user.setPassword("123");
        user.setUserName("oga123");

        Customer customer = new Customer();
        customer.setLastName("ga");
        customer.setName("O");
        customer.setUser(user);

        user.setCustomer(customer);

        userDao.insert(user);

        User userInerted = userDao.findById(user.getId());

        log.info(user.getId().toString());
        assertEquals(user.toString(), userInerted.toString());
    }
}
