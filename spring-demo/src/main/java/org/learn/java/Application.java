package org.learn.java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    public static void main(String[] args) {
       /* ClassB b = new ClassB();
         ClassA a = new ClassA();
        b.setA(a);     // empty object return null always. and it returns np exception cz fetching member with no value.
        System.out.println(b.getA().doSomething());*/

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        // creates bean,  the objects that form the backbone of your application and that are managed by the
        // Spring IoC container are called beans.


        System.out.println("Application context is loaded");
     //ClassB  b1 = (ClassB) context.getBean("ourBetterBean");

       // ClassB  b1 = (ClassB) context.getBean("ClassB");
      // System.out.println(b1.getId());
/*

        ClassB  b2 =context.getBean(ClassB.class);
        b2.setId(2000);
        System.out.println(b2.getId());

        System.out.println(b1.getId());

*/
        //((AnnotationConfigApplicationContext)context).close();


    }
}

/* so by default at certain point it is singleton, so it remains the value for first one same as updated.
prototype will give the value of first one.so, basically it will always have the main copy and when you create new
object it will give us back the clone copy of main object.

*/