package com.example.demo.ejercicio27.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.User;

@Repository
public class UserDAO extends GenericHibernateDAO<User, Long> implements IUserDAO {
    
    public UserDAO(){
        super(User.class);
    }
}
