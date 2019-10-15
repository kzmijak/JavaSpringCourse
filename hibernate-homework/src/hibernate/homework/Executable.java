package hibernate.homework;

import hibernate.homework.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Executable
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        deleteFromDb(1, factory);

        factory.close();
    }

    private static void saveToDb(Employee employee, SessionFactory factory)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    private static Employee getFromDb(int id, SessionFactory factory)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        return employee;
    }

    private static List<Employee> getEmployees(String company, SessionFactory factory)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee e where e.company='" + company + "'").getResultList();
        session.getTransaction().commit();
        return employees;
    }

    private static void deleteFromDb(int id, SessionFactory factory)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Employee where id='" + id + "'").executeUpdate();
        session.getTransaction().commit();
    }

    private static String viewList(List<Employee> employees)
    {
        String string = new String();
        for(Employee employee : employees)
        {
            string+=employee.toString()+"\n";
        }
        return string;
    }
}
