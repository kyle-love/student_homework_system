package org.example.javaee.springMVC.spring;

import org.example.javaee.springMVC.bean.testers1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        int n = 10;
        while( n-->0){
            testers1 test = context.getBean("testBean", testers1.class);
            System.out.println(test.toString());
        }

    }
}
