package com.example.demo.ejercicio8;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subject {
    private String name;
    private Teacher teacher;
}
