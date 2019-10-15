package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("testingDude")
public class TestingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Test your shit";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
