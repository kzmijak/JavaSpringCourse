package com.luv2code.springdemo;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FinalCoach implements Coach {

    @Autowired
    @Qualifier("finalFortuneService")
    private FortuneService fortuneService;



    @Override
    public String getDailyWorkout() {
        return "Proceed with my final fantasy";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }
}
