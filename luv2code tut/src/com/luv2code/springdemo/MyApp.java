package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //create the object
        Coach theCoach = new TrackCoach(context.getBean("myFortuneService", FortuneService.class));

        //use the object
        System.out.println(theCoach.getDailyFortune());
        context.close();
    }
}
