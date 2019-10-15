package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo
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

            try {
                System.out.println("Beginning a transaction...");
                session.beginTransaction();

                // get the course
                int id = 10;
                Course course = session.get(Course.class, id);

                // print the course
                System.out.println(course);

                // print the course reviews
                for(Review r: course.getReviews())
                {
                    System.out.println(r);
                }

                System.out.println("Committing transaction...");
                session.getTransaction().commit();

            } finally {
                session.close();
                factory.close();
                System.out.println("Done!");
            }
    }
}
