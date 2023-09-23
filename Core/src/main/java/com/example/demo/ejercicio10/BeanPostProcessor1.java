package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor1 implements BeanPostProcessor, Ordered {
    
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 befor initialization...");

        if(bean instanceof IWorker){
            Worker worker = (Worker)bean;

            log.info("Worker name {}", worker.getName());
            worker.setName("Otro oga mas before 1");
            log.info("Worker name cambiado {}", worker.getName());
        }

        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 after initialization....");

        if(bean instanceof IWorker){
            Worker worker = (Worker)bean;

            log.info("Worker name {}", worker.getName());
            worker.setName("Otro oga mas after 1");
            log.info("Worker name cambiado {}", worker.getName());
        }

        return bean;
    }

    @Override
    public int getOrder(){
        return 0;
    }
}
