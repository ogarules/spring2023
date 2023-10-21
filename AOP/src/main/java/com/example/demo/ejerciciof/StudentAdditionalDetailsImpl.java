package com.example.demo.ejerciciof;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class StudentAdditionalDetailsImpl implements StudentAdditionalDetails {
    private String city;
    private String country;

    @Override
    public void showAdditionalDetails() {
        log.info(city);
        log.info(country);
    }
}
