package org.learn.java;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassA {

    public String doSomething(){
        return "Hello Spring world";
    }

    @PostConstruct
    public void init(){
        System.out.println("init class A method got called");
    }

    @PreDestroy
    public void predestroy(){
        System.out.println("destroy class A method got called");
    }
}
