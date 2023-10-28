package com.example.demo.ejercicio25.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate extends Date {
    
    private DateFormat formatter = new SimpleDateFormat("dd/MM/YYY hh:mm:ss");

    public CustomDate(){
        super();
    }

    public CustomDate(long time){
        super(time);
    }

    @Override
    public String toString(){
        return formatter.format(this);
    }
}
