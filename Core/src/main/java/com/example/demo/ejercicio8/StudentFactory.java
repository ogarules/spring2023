package com.example.demo.ejercicio8;

public class StudentFactory {
    
    public Student getStudent(String name, String subject, String teacherName){
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
