package com.example.demo.ejercicio1;

public class Aadvark extends Animal implements BugEater {

    @Override
    public String consume(Bug bug) {
        return "Aadvark consuming bug";
    }

    @Override
    public String consume(Water bug) {
        return "Aadvark consuming water";
    }

    @Override
    public String walk() {
        return "Aadvark walking in four legs";
    }
    
}
