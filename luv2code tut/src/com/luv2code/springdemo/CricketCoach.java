package com.luv2code.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public CricketCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: Inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: Inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: Inside setter method - setTeam");
        this.team = team;
    }

    public String getEmailAddress() {
        System.out.println("CricketCoach: Inside getter method - getEmailAddress");
        return emailAddress;
    }

    public String getTeam() {
        System.out.println("CricketCoach: Inside getter method - getTeam");
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
         return fortuneService.getFortune();
    }



    //add an init method
    public void doMyStartupStuff()
    {
        System.out.println("CricketCoach: inside method doMyStartupStuff");
    }

    //add a destroy metod
    public void doMyCleanupStuffYoYo()
    {
        System.out.println("CricketCouah: inside method doMyStartupStuff");
    }
}
