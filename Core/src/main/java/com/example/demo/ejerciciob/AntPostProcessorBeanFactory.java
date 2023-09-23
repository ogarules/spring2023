package com.example.demo.ejerciciob;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AntPostProcessorBeanFactory implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Injection new beans...");
        
        GenericBeanDefinition definition = new GenericBeanDefinition();

        definition.setBeanClass(Ant.class);
        definition.getPropertyValues().add("color", "red");

        ((DefaultListableBeanFactory)beanFactory).registerBeanDefinition("antbean", definition);


    }
}
