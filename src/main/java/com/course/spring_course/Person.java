package com.course.spring_course;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("Person was created");

    }

    public void callYourPet(){
        System.out.println("Hello, my pet");
        pet.say();
    }

    public void setPet(Pet pet) {
        System.out.println("Pet was set");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
