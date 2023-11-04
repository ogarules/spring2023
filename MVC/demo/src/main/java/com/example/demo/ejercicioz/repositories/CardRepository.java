package com.example.demo.ejercicioz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ejercicioz.domain.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    
}
