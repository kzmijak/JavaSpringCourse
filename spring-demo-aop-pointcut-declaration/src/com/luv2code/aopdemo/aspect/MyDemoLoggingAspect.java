package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect
{
    // this is where we add all of our related advices for logging

    // let's start with an add @Before advice

    @Pointcut("execution(* add*(com.luv2code.aopdemo.Account, ..))")
    private void forDaoPackage(){}


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println("\n=====> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        for (Object temp: args)
        {
            if(temp instanceof Account)
            {
                Account account  =(Account) temp;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
            else
                System.out.println(temp);
        }
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics()
    {
        System.out.println("SIEMA KLUCHY");
    }


}
