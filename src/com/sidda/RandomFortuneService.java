package com.sidda;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] data = { "Beware", "Diligence", "The journey" };
    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);
        return data[index];
    }

}
