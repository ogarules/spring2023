package com.example.demo.ejercicio27.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.ejercicio27.dao.IAccountDAO;
import com.example.demo.ejercicio27.domain.Account;
import com.example.demo.ejercicio27.domain.Customer;

@Repository
public class AccountDAO extends GenericHibernateDAO<Account, Long> implements IAccountDAO {
    
    public AccountDAO(){
        super(Account.class);
    }

    @Override
    public List<Account> findByCustomerId(Long id){
        return (List<Account>)this.sessionFactory.getCurrentSession()
               .createQuery("FROM " + this.persistentClass.getName() + " WHERE customer = " + id)
               .list();
    }
}
