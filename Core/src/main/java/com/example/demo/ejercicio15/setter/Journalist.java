package com.example.demo.ejercicio15.setter;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.Getter;

@Getter
public class Journalist {
    private String name;
    private Integer age;
    private String rfc;

    private Notebook notebook;
    private Pen pen;

    @Autowired
    private void setName(String name){
        this.name = name;
    }

    @Autowired
    private void setAge(Integer age){
        this.age = age;
    }

    @Autowired
    private void setRfc(String rfc){
        this.rfc = rfc;
    }

    @Autowired
    private void setNotebook(Notebook notebook){
        this.notebook = notebook;
    }

    @Autowired
    private void setPen(Pen pen){
        this.pen = pen;
    }
}
