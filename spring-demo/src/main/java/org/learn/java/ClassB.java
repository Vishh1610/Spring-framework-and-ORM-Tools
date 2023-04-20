package org.learn.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;


//@Scope(value = "prototype")
public class ClassB {

    @Value("1617")
    private int id;

    @Inject              // class a inject directly to b
    private ClassA a;

    @PostConstruct
    public void init(){
        System.out.println("init class B method got called");
    }

    @PreDestroy
    public void predestroy(){
        System.out.println("destroy class B method got called");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassA getA() {
        return a;
    }

    public void setA(ClassA a) {
        this.a = a;
    }
}
