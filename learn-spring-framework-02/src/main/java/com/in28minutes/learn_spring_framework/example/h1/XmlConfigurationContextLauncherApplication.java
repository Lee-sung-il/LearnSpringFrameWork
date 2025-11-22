package com.in28minutes.learn_spring_framework.example.h1;


import com.in28minutes.learn_spring_framework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GameRunner.class).run();
        }
    }
}

/*
Heading              Annotations                                                    XML Configuration
Ease of use          Very Easy(defined close to source - class, method and/or       Cumbersome
                     variable)
Short and concise    Yes                                                            NO
clean POJOs          NO. POJOs are polluted with Spring Annotations                 Yes. NO change in java code.
Easy to Maintain    Yes                                                             No
Usage Frequency     Almost all recent projects                                      Rarely
Debugging           Hard                                                            Medium
difficulty

 */
