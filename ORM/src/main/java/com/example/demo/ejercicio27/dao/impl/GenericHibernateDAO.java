package com.example.demo.ejercicio27.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.ejercicio27.dao.IGenericDAO;

import lombok.Getter;

public class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T,ID> {

    protected @Getter final Class<T> persistentClass;
    private Session session;

    @Autowired
    protected @Getter SessionFactory sessionFactory;

    public GenericHibernateDAO(Class<T> type){
        this.persistentClass = type;
    }

    @PostConstruct
    public void postConstruct(){
        try {
            session= this.sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
    }

    @Override
    public void insert(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public T findById(ID id) {
        return this.session.get(this.persistentClass, id);
    }

    @Override
    public T delete(ID id) {
        T entity = this.findById(id);
        return this.delete(entity);
    }

    @Override
    public T delete(T entity) {
        session.delete(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return (List<T>)session.createQuery("FROM " + this.persistentClass.getName()).list();
    }
    
}
