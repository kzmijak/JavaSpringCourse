package com.luv2code.springdemo;
import java.util.Random;

public class HappyFortuneService implements FortuneService
{
    private static String[] fortunes = {
            "This is a neutral fortune, your day is gonna be -shall I say- average at best",
            "It is an okay fortune, your day is gonna be just fine",
            "Wow, lucky you, this is a super cool fortune, n 1 c e"
    };

    @Override
    public String getFortune()
    {
        Random rand = new Random();
        int n = rand.nextInt(3);

        return fortunes[n];
    }
}
