package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Олег", "Сидоров", "Sales", 700);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int maId = emp.getId();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class,maId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Операции успешно выполнены");
        } finally {
            factory.close();
        }
    }
}
