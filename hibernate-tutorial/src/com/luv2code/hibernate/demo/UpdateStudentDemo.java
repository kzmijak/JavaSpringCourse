package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo
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
            int studentId = 1;

            // now get a new session and start transaction

            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\n Getting student with id: " + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("Get complete: " + student);

            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            // update email for all students
            System.out.println("Updating email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally
        {
            factory.close();
        }

    }
}
