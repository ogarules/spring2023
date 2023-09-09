package com.example.demo.ejercicio8;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private Subject subject;

    public static Student constructStudent(String name, String subject, String teacherName){
        return Student.builder()
        .name(name)
        .subject(Subject.builder()
                        .name(subject)
                        .teacher(Teacher.builder()
                                        .name(teacherName)
                                        .build())
                        .build())
        .build();
    }
}
