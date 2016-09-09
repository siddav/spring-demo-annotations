package com.sidda;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
        context.close();
    }

}
