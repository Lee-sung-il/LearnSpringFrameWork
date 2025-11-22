package com.in28minutes.learn_spring_framework.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (BeanScopesLauncherApplication.class)) {
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));


            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}

/**
 *Heading                Prototype                                      Singleton
 *Instance               Possibly Many per SpringIoc Container          One per SpringIoc Container
 *Beans                  New bean instance created every time           Same bean instance reused
 *                       the bean is requested
 *Default                Not Default                                    Default
 *Code Snippet          @Scope(value =                                  @Scope(value =
 *                      ConfigurableBeanFactory.SCOPE_PROTOTYPE)        ConfigurableBeanFactory.SCOPE_SINGLETON OR Default)
 *usage                 Rarely used                                     Very frequently used
 *Recommended           Stateful beans                                   Stateless beans
 *Scenario
 */

