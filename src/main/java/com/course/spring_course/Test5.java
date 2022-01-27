package com.course.spring_course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Pet pet = context.getBean("myPet",Pet.class);
        pet.say();

        Pet pet2 = context.getBean("myPet",Pet.class);
        pet2.say();




        context.close();
    }

}
