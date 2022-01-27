package com.course.spring_course;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("com.course.spring_course")
public class MyConfig {

    @Bean
    @Scope ("prototype")
    public Pet catBean(){
        return new Cat();
    }
    @Bean
    public Person personBean(){
        return new Person(catBean());
    }

}
