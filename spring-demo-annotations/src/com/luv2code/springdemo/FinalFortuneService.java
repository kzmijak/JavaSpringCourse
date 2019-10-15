package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FinalFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "This is my final fortune";
    }
}
