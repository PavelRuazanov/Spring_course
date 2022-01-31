package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка " +
                "студентов перед методом getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterGetStudentsLoggingAdvice(List<Student> students){
        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr" + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = 3+ avgGrade;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterGetStudentsLoggingAdvice: логируем получение списка " +
                "студентов после метода getStudents");
    }
    @AfterThrowing (pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsAdvice: логируем выброс исключения" + exception);

    }
    @After("execution(* getStudents())")
    public void afterGetStudentsAdvice(){
        System.out.println("afterGetStudentsAdvice: Логируем нормальное завершение программы или выброс исключения");
    }

}
