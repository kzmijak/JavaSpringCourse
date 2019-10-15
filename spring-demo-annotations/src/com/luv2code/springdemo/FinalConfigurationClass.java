package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luv2code.springdemo")
public class FinalConfigurationClass
{
    //@Bean
    public FortuneService finalFortuneService()
    {
        return new FinalFortuneService();
    }


    //@Bean
    public Coach finalCoach()
    {
        return new FinalCoach();
    }
}
