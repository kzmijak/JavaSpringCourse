package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo
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

            //get the instructor from db
            Instructor instructor = session.get(Instructor.class, 1);

            // create some courses
            Course course = new Course("Douchebagery");

            // add courses to instructor
            session.save(course);
            instructor.add(course);

            // save the courses

            session.update(instructor);
            session.getTransaction().commit();

        }
        finally
        {
            session.close();
            factory.close();
            System.out.println("Done!");
        }
    }
}
