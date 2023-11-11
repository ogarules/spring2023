package com.example.demo.ejercicio30.parte2.models;

import lombok.Data;
import java.util.List;

@Data
public class Contact {
    private String name;
    private String email;
    private String gender;
    private String password;
    private String confirmPassword;
    private List<String> courses;
    private String tutor;
    private String hiddenMessage;
}
