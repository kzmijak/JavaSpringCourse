package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo
{
    public static void main(String[] args) {
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

            Instructor instructor = session.get(Instructor.class, 1);
            List<Course> courseList = instructor.getCourses();
            instructor.getCourses();
            System.out.println(session.get(Course.class, 1));

            session.getTransaction().commit();


            //System.out.println("Courses: " + courseList);
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}