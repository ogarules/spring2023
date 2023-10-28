package com.example.demo.ejercicio24.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import com.example.demo.util.IColorWriter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ProfilingAspect implements Ordered {
    
    private @Getter int order = 1;

    @Autowired
    private IColorWriter colorWriter;

    @Around("within(com.example.demo.ejercicio24..*)")
    public Object aroundProfilingExecution(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(pjp.toShortString());

        log.info("Profiling " + pjp.getSignature().getName());

        boolean isException = false;

        try {
            return pjp.proceed();
        } catch (Exception e) {
            isException=true;
            throw e;
        }
        finally{
            stopWatch.stop();
            TaskInfo taskInfo = stopWatch.getLastTaskInfo();

            String message = taskInfo.getTaskName() + " : " + taskInfo.getTimeMillis() + " ms " + (isException ? "(thrown Exception)" : "");
            log.info(message);
        }
    }
}
