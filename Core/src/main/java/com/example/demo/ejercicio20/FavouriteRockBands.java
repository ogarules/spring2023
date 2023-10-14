package com.example.demo.ejercicio20;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("favouriteRockBand")
public class FavouriteRockBands {
    
    @Value("${favourite.rockband.first}")
    private String firstRockBand;

    @Value("${favourite.rockband.second}")
    private String secondRockBand;

    @Value("My favourite rockbands are ${favourite.rockband.first} and ${favourite.rockband.second}")
    private String descritption;

    @Override
    public String toString(){
        return descritption;
    }
}
