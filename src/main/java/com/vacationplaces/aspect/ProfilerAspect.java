package com.vacationplaces.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ProfilerAspect {
    Logger logger = LoggerFactory.getLogger(ProfilerAspect.class);


    @Pointcut("execution(public * org.springframework.data.repository.Repository+.*(..))")
    public void monitor() {}

    @Around("monitor()")
    public Object profile(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        logger.info("JVM memory in use = "+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        Object output = null;
        try {
            output = pjp.proceed();
        } catch (Throwable e) {
            logger.info(e.getMessage());
        }
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info(pjp.getTarget()+"."+pjp.getSignature()+": Execution time: " + elapsedTime + " ms. ("+ elapsedTime/60000 + " minutes)");

        return output;
    }
}
