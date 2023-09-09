package com.example.demo.ejercicio6;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DatabaseConnection implements InitializingBean, DisposableBean {

    private String database;
    private String user;
    private String password;

    @Override
    public void destroy() throws Exception {
        log.info("Destroying database connection (app context)");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connecting to database after property set");
    }

    public void connect(){
        log.info("Conectandose a => {} {} {}", database, user, password);
    }

    public void disconnect(){
        log.info("Desconectandose de => {} {} {}", database, user, password);
    }
}
