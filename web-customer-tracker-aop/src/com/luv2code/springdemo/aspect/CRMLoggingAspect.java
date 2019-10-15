package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect
{
    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // do the same for service and dao
    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}


    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        // display the method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========> in @Before: calling method: " + method);

        // display the arguments of the method
        Object[] args = joinPoint.getArgs();

        // loop through and display args
        for(Object arg: args)
        {
            logger.info("\n============> argument: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        // display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("=======> in @AfterReturning: from method: " + method);

        // display data return
        logger.info("=========> result: " + result);

    }



}
