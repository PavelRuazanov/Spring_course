package com.course.spring_course;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("dogBean")
//@Scope ("prototype")

public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Гав-гав");
    }

}
