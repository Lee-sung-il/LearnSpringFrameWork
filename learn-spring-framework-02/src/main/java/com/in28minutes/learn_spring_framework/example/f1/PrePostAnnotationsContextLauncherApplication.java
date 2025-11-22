package com.in28minutes.learn_spring_framework.example.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("CleanUp");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostAnnotationsContextLauncherApplication.class)) {
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

                @Component                                      @Bean
Where           Can be used on any Java class                   Typically used on methods in Spring Configuration Classes
Ease of use     Very easy Just add an annotation                You write all the code.
Autowiring      Yes-Field, Setter or Constructor Injection      Yes-method call or method parameters
Who creates     Spring Framework                                you write bean creation code
bean
Recommended     Instantiating Beans for Your Own Application    1: Custom Business Logic
For             Code: @Component                                2: Instantiating Beans for 3rd-party Libraries: @Bean

 */