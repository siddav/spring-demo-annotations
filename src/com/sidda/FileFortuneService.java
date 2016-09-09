package com.sidda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
    @Value("${fortune.fileName}")
    private String fortuneFileName;
    private String[] fortunes;
    private Random random = new Random();

    @Override
    public String getFortune() {
        System.out.println("file name: " + fortuneFileName);
        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource(fortuneFileName).toURI());
        } catch (URISyntaxException e) {
            System.out.println("error occured while reading file: " + fortuneFileName);
            e.printStackTrace();
        }
        System.out.println("file exists " + Files.exists(path));
        List<String> fortuneStrings = new ArrayList<>();
        try {
            Files.lines(path).forEach(new Consumer<String>() {

                @Override
                public void accept(String t) {
                    fortuneStrings.add(t);
                }

            });
        } catch (IOException e) {
            System.out.println("Exception occured while reading file: " + fortuneFileName + " contents");
            e.printStackTrace();
        }
        fortunes = new String[fortuneStrings.size()];
        fortunes = fortuneStrings.toArray(fortunes);
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }

}
