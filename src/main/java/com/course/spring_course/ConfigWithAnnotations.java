package com.course.spring_course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
Person person = context.getBean("personBean",Person.class);
person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurname());



//        Cat cat = context.getBean("catBean",Cat.class);
//        cat.say();

        context.close();
    }
}
