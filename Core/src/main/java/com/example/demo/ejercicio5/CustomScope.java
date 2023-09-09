package com.example.demo.ejercicio5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScope implements Scope {
    
    private Map<String, Object> objectMap = Collections.synchronizedMap(new HashMap<>());

    private int n = 0;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        log.info("Solicitando bean ...");

        if(n >= 5){
            log.info("Limpiando beans generados...");
            this.objectMap.clear();
            n=0;
        }

        if(!this.objectMap.containsKey(name)){
            log.info("Construyendo nuevo bean...");

            Object bean = objectFactory.getObject();
            this.objectMap.put(name, bean);
        }

        n++;

        return this.objectMap.get(name);
    }

    @Override
    @Nullable
    public Object remove(String arg0) {
        return this.objectMap.remove(arg0);
    }

    @Override
    public void registerDestructionCallback(String arg0, Runnable arg1) {

    }

    @Override
    @Nullable
    public Object resolveContextualObject(String arg0) {
        return null;
    }

    @Override
    @Nullable
    public String getConversationId() {
        return "CustomScope";
    }
}
