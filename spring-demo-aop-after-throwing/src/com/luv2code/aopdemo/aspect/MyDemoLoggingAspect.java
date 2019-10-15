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
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc)
    {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=========>>> Exception: " + theExc);
    }

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
