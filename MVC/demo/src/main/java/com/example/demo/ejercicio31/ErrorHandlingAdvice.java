package com.example.demo.ejercicio31;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(assignableTypes = {})
public class ErrorHandlingAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponseError onException(IllegalArgumentException e){
        log.error("Ocurrio un erro no manejado", e);
        return new RestResponseError(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrio un error no esperado contacte al adminsitrador", e.getMessage());
    }

    
}
