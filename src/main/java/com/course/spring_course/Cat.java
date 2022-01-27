package com.course.spring_course;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("catBean")
//@Scope ("singleton")
public class Cat implements Pet{
    @Override
    public void say() {
        System.out.println("Мяу-Мяу");
    }

@PostConstruct
    public void init(){
        System.out.println("Cat class: init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Cat class: destroy");
    }
}
