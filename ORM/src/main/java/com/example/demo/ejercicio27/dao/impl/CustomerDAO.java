package com.example.demo.ejercicio27.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.domain.Customer;

@Repository
public class CustomerDAO extends GenericHibernateDAO<Customer, Long> implements ICustomerDAO {
    
    public CustomerDAO(){
        super(Customer.class);
    }
}
