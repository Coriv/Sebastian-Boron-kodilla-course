package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FacadeWatcher {

    public static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("Logging event");
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void throwEvent() {
        LOGGER.error("Throw event");
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object object(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Consumed time: " + (end - begin));
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
