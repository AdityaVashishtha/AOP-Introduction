package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggableAspect {

    private static final Logger LOGGER
            = Logger.getLogger(LoggableAspect.class.getName());

    @Pointcut("@annotation(com.example.aop.annotation.Loggable)")
    public void aspectPointCutDefinition() {
    }

    @Before("aspectPointCutDefinition()")
    public void executeBeforeLoggable(JoinPoint joinPoint) {
        LOGGER.info(String.format(
                "Entering Method {%s} of {%s}",
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().getDeclaringType()));
    }

    @After("aspectPointCutDefinition()")
    public void executeAfterLoggable(JoinPoint joinPoint) {
        LOGGER.info(String.format(
                "Exiting Method {%s} of {%s}",
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().getDeclaringType()));
    }

    @Around("aspectPointCutDefinition()")
    public Object executeAroundLoggable(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long after = System.currentTimeMillis();
        LOGGER.info("Execution time " + (after - before) + " ms");
        return proceed;
    }


    @AfterThrowing(value = "aspectPointCutDefinition()", throwing = "ex")
    public void executeAfterThrowingLoggable(RuntimeException ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage());
    }

    @AfterReturning(value = "aspectPointCutDefinition()", returning = "returnObject")
    public void executeAfterReturnLoggable(Object returnObject) {
        LOGGER.info("Return value {" + returnObject + "}");
    }

}
