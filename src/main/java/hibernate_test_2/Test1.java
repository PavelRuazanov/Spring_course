package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
//            Employee employee = new Employee("Павел","Рязанов", "IT", 800);
//            Detail detail = new Detail("Казань","1231425313", "dsfsd@gmail.com");
//
//            employee.setEmpDetail(detail);



            session.beginTransaction();
            Employee employee = session.get(Employee.class,2);
session.delete(employee);


            session.getTransaction().commit();

            System.out.println("операции успешно выполнены");
        } finally {
            session.close();
            factory.close();
        }
    }
}
