package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp
{
    public static void main(String[] args)
    {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        //edit and display changes
        boolean result = (theCoach == alphaCoach);
        System.out.println(result);

        ((CricketCoach) theCoach).setTeam("Lolitas");
        System.out.println(((CricketCoach) alphaCoach).getTeam());


        //close context
        context.close();

    }
}
