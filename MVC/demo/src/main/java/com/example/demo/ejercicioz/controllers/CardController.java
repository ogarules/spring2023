package com.example.demo.ejercicioz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicioz.domain.Card;
import com.example.demo.ejercicioz.services.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("card")
public class CardController {
    
    @Autowired
    CardService service;

    @GetMapping(value="/{id}")
    public Card getCardInfo(@PathVariable Long id) {
        return service.getCardInfo(id);
    }

    @GetMapping
    public Iterable<Card> getAllCardsInfo() {
        return service.getAllCardInfo();
    }
    
    @PostMapping
    public Card postMethodName(@RequestBody Card entity) {
        
        return service.addCardInfo(entity);
    }
    
}
