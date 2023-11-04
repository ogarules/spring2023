package com.example.demo.ejercicioz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicioz.domain.Card;
import com.example.demo.ejercicioz.repositories.CardRepository;

@Service
public class CardService {
    
    @Autowired
    CardRepository repository;

    public Card getCardInfo(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Card addCardInfo(Card card){
        return repository.save(card);
    }

    public Iterable<Card> getAllCardInfo(){
        return repository.findAll();
    }
}
