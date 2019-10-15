package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinalRunApi
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(FinalConfigurationClass.class);

        FinalCoach finalCoach = context.getBean("finalCoach", FinalCoach.class);

        System.out.println(finalCoach.getDailyFortune());
        System.out.println(finalCoach.getDailyWorkout());

        context.close();

    }
}
