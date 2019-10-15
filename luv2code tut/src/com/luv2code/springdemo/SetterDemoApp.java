package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp
{
    public static void main(String[] args)
    {
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //retrieve bean from spring container
        FortuneService fortuneService = context.getBean("myFortuneService", FortuneService.class);
        Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
        //call methods on bean
        System.out.println(cricketCoach.getDailyFortune());

        System.out.println(((CricketCoach) cricketCoach).getTeam());
        //close the context
        context.close();
    }
}
