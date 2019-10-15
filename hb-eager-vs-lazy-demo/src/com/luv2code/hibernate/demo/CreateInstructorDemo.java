package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Guitar");
            Course course = new Course("Programming");

                System.out.println("Adding course and detail to instructor...");
            instructor.add(course);
            instructor.setInstructorDetail(instructorDetail);

                System.out.println("Saving instructor to the database");
            session.save(instructor);

                System.out.println("Applying changes...");
            session.getTransaction().commit();

                System.out.println(instructor.coursesToString());
        }
        finally
        {
            session.close();
            factory.close();
            System.out.println("Done!");
        }
    }
}
