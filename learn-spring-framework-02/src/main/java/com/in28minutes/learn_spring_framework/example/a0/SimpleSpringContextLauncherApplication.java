package com.in28minutes.learn_spring_framework.example.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (SimpleSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

/*
Component : An instance of a class will be manged by Springframework
Dependency: GameRunner needs GamingConsole impl!
    GamingConsole impl (Ex: MarioGame) is a dependency of GameRunner

Component Scan: How does Spring Framework find component Class?
it scans packages! (@ComponentScan("com.in28minutes"))

Dependency Injection: Identify beans, their dependencies and wire together
(provides IOC - inversion of Control)

Spring Beans : An object manged by springframework
ioc Container : Manages the lifecycle of beans and dependencies
Types: ApplicationContext(complex), BeanFactory(simple featured - rarely used)

AutoWiring : Process of wiring dependencies for a Spring Bean

 */