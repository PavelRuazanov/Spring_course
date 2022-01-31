package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Иван иванов", 1,4.3);
        Student st2 = new Student("Михаил Васильев", 2,5.3);
        Student st3 = new Student("Иван Петров", 3,2.3);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    public List<Student> getStudents (){
        System.out.println("Начало работы метода getStudents");
//        System.out.println(students.get(3));
        System.out.println("Information from get students: ");
        System.out.println(students);
        return students;
    }

}
