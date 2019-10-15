package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo
{
    public static void main(String[] args)
    {
        // create session factory

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try
        {
            session.beginTransaction();

            // get the instructor detail object
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);

            // print the instructor detail object
            System.out.println(instructorDetail);

            // print the associated instructor
            System.out.println(instructorDetail.getInstructor());

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            factory.close();
        }

    }
}
