package com.example.demo.ejerciciog;

import java.lang.reflect.Method;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PerformanceAdvisor implements MethodBeforeAdvice, AfterReturningAdvice {
    
    private long start=0;
    private long end = 0;

    @Override
    public void afterReturning(@Nullable Object arg0, Method arg1, Object[] arg2, @Nullable Object arg3) throws Throwable {
        end = System.currentTimeMillis();

        log.info("Finished executing {} on object {} in {} milliseconds", arg1.getName(), arg1.getClass().getName(), end -start);
    }

    @Override
    public void before(Method arg0, Object[] arg1, @Nullable Object arg2) throws Throwable {
        start = System.currentTimeMillis();

        log.info("Executing method {} on object {}", arg0.getName(), arg0.getClass().getName());
        
    }
}
