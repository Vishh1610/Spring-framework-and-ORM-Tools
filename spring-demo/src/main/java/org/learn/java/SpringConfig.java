package org.learn.java;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.learn.java")
public class SpringConfig {

    @Bean
    @Lazy
    public ClassA classA(){
        return new ClassA();
    }

    @Bean(name = "ourBestBean")
    @Scope("prototype")
    @Lazy
    public ClassB classB(){
        return new ClassB();
    }

    @Bean(name = "ourBetterBean")
    // @Scope("prototype")
    @Lazy
    public ClassB classBAnotherBean(){
        return new ClassB();
    }

}
