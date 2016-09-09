package com.sidda;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * three types of injections 1. constructor injection 2. setter injection 3.
 * field injection
 */
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    //    @Autowired
    //    public TennisCoach(FortuneService theFortuneService) {
    //        this.fortuneService = theFortuneService;
    //    }

    public TennisCoach() {
        System.out.println("TennisCoach: inside default constructor");
    }

    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("doMyStartUpStuff");
    }
    @Override
    public String getDailyWorkOut() {
        return "practise your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //    @Autowired
    //    public void setFortuneService(FortuneService fortuneService) {
    //        System.out.println("TennisCoach: inside setter fortuneService");
    //        this.fortuneService = fortuneService;
    //    }
    //    @Autowired
    //    public void doSomeCrazyStuff(FortuneService fortuneService) {
    //        System.out.println("TennisCoach: inside dosomeCrazystuff");
    //        this.fortuneService = fortuneService;
    //    }
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("doMyCleanUpStuff");
    }
}
