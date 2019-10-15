package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo
{
    public static void main(String[] args)
    {
        // create session factory

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try
        {
            int studentId = 2;

            session.beginTransaction();

            System.out.println("Retrieveing student with the ID of " + studentId +"...");
            Student student = session.get(Student.class, studentId);

            // delete the student as an object
            System.out.println("Deleting as object...");
            //session.delete(student);

            // delete the student as a query
            System.out.println("Deleting as query...");
            session.createQuery("delete from Student where id=3").executeUpdate();

            session.getTransaction().commit();
            System.out.println("DONE!");
        }
        finally
        {
            factory.close();
        }

    }
}
