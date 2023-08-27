package com.example.examenspringboot;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectLog {
    //type de retour void ; tous les methodes ; pas parametre
    @AfterReturning("execution(public * com.example.examenspringboot.services.*.*(..))")
    void journal(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        log.info("methode executee avec succes ");
    }
}
