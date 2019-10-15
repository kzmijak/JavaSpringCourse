package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo
{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try
        {
            System.out.println("Beginning a transaction...");
            session.beginTransaction();

            System.out.println("Creating a course...");
            Course course = new Course("Pacmania");
            Student student1 = new Student("Jan", "Kowalski", "p@f");
            Student student2 = new Student("Pan", "Rowalski", "x@f");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);
            session.save(course);


            System.out.println("Committing transaction...");
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();

        }

    }
}
