package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo
{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try
        {
            System.out.println("Beginning a transaction...");
            session.beginTransaction();

            System.out.println("Creating a course...");
            Course course = new Course("Pacman = How To Score One Million Points");

            System.out.println("Adding reviews...");
            course.add(new Review("Great course... loved it!"));
            course.add(new Review("Great course... I hate it!"));
            course.add(new Review("Bad course... loved it!"));
            course.add(new Review("Bad course... I hate it!"));


            System.out.println("Committing transaction...");
            session.save(course);
            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
            System.out.println("Done!");
        }

    }
}
