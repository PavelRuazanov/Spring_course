package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order (1)
public class LoggingAspect {


//    @Pointcut("execution(* aop.UniLibrary.* (..))")
//private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineMethodFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineMethodFromUniLibrary()")
//    private void allMethodsFromUniLibraryExceptReturnMagazine(){}
//
//    @Before("allMethodsFromUniLibraryExceptReturnMagazine()")
//    public void beforeAllMethodsFromUniLibraryExceptReturnMagazine(){
//        System.out.println("beforeAllMethodsFromUniLibraryExceptReturnMagazine: Write Log # 1");
//    }

//    @Pointcut("execution (* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution (* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice : writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice : writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice : writing Log #3");
//    }





    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("signature = " + signature);
        System.out.println("signature.getMethod = " + signature.getMethod());
        System.out.println("signature.getReturnType = " + signature.getReturnType());
        System.out.println("signature.getName = " + signature.getName());

        if (signature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments){
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название книги - " + myBook.getName());
                    System.out.println("Автор - " + myBook.getAuthor());
                    System.out.println("Год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет - " + obj);
                }
            }
        }




        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("-------------------------------------");

    }

    @Before("execution(public * return*())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
        System.out.println("-------------------------------------");

    }


}
