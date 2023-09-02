package com.example.demo.ejercicio1;

public class VenusFlyTrap extends Plant implements BugEater {

    @Override
    public String consume(Bug bug) {
        return "Venus fly trap consuming bug";
    }

    @Override
    public String comsume(SunLight sunlight) {
        return "Venus fly trap consuming sunlight";
    }
    

}
