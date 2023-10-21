package com.example.demo.ejerciciof;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class StudentImpl implements Student {
    private int studentNo;
    private String studentName;

    @Override
    public void showDetails() {
        log.info("{}", studentNo);
        log.info(studentName);
    }
}
