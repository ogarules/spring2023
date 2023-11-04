package com.example.demo.ejercicioz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.example.demo.ejercicioz.domain.Card;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class CardMasker {
    
    @Around("execution(Iterable<com.example.demo.ejercicioz.domain.Card> com.example.demo.ejercicioz.services.*.*(..))")
    public Object maskCards(ProceedingJoinPoint pjp) throws Throwable{
        Object result = pjp.proceed();

        log.info("Masking cards...");

        Iterable<Card> cardItems = (Iterable<Card>)result;

        for (Card card : cardItems) {
            card.setCardNumber("XXXX-XXXX-XXXX-XXXX");
        }

        return result;
    }
}
