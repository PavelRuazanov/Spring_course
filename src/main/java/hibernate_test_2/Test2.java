package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
//
//            Employee employee = new Employee("Павел","Рязанов", "IT", 800);
//            Detail detail = new Detail("Казань","1231425313", "dsfsd@gmail.com");
//
//            detail.setEmployee(employee);
//            employee.setEmpDetail(detail);

            session.beginTransaction();

            Detail detail = session.get(Detail.class,3);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();

            System.out.println("операции успешно выполнены");
        } finally {
            session.close();
            factory.close();
        }
    }
}
