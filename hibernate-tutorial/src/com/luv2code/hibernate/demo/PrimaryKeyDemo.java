package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo
{
    public static void main(String[] args) {
        // create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try
        {
            // use the session object to save java object

            // create 3 new student objects
            System.out.println("Creating a new student object...");
            Student tempStudent1 = new Student("Paul", "Wall","paul@luv2code.com");
            Student tempStudent2 = new Student("Jake", "Paul","paul@luv2code.com");
            Student tempStudent3 = new Student("Tony", "Roll","paul@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally
        {
            factory.close();
        }
    }
}
