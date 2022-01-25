package com.course.spring_course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Pet pet = context.getBean("myPet",Pet.class);
        Pet yourPet = context.getBean("myPet",Pet.class);
        pet.say();
        System.out.println("Это одинаковые коты? " + (pet == yourPet));
        System.out.println(pet);
        System.out.println(yourPet);
        context.close();
    }
}
