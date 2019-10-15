package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo
{
    public static void main(String[] args)
    {
        // create session factory

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try
        {
            // start transaction
            session.beginTransaction();

            // query transaction
            List<Student> students = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(students);

            // query students: lastName = Wanker
            students = session.createQuery("from Student s where s.lastName='Wanker'").getResultList();

            // display the students
            System.out.println("Students who have the last name of Wanker: ");
            displayStudents(students);

            // query students: lastName = 'Duck' OR firstName = 'Tony'
            students = session.createQuery("from Student s where s.lastName='Duck'"
                                                + "OR s.firstName = 'Tony'").getResultList();
            displayStudents(students);

            //query students where email LIKE '%luv2code.com'
            students = session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
            System.out.println(students);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally
        {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for (Student student: students)
        {
            System.out.println(student);
        }
    }
}
