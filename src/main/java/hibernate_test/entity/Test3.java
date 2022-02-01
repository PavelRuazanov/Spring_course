package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee ")
//                    .getResultList();

            List<Employee> employees = session.createQuery("from Employee " +
                            "where department = 'IT' and salary < 400" )
                    .getResultList();
            for (Employee e : employees) {
                System.out.println(e);
            }


            session.getTransaction().commit();
            System.out.println("Операции успешно выполнены");
        } finally {
            factory.close();
        }
    }
}
