package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

            Student student = new Student();
            student.setId(11);
            student.setStudentName("priya");
            session.persist(student);
            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}