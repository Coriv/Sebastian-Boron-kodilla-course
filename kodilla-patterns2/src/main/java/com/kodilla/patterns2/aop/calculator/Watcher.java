package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
     "&& args(theNumber) && target(object)")
    public void logEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object resul;
        try {
            long begin = System.currentTimeMillis();
            resul = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end-begin));
        } catch (Throwable e) {
            LOGGER.info(e.getMessage());
            throw new Throwable();
        }
        return resul;
    }
}
