package com.example.demo.ejercicio25.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.demo.ejercicio25.dao.IGenericDAO;

public abstract class GenericSpringJdbcDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
    
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected NamedParameterJdbcTemplate namedJdbcTemplate;

}
