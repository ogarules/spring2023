package com.example.demo.ejercicio31;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class RestResponseError {
    
    private int status;
    private String message;
    private String exception;

    public RestResponseError(HttpStatus status, String message, String exception){
        this.status = status.value();
        this.message = message;
        this.exception = exception;
    }
}
