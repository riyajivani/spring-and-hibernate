//using h2 database{inbuilt} not using mysql

package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure(); //it always load hibernate.cfg.xml file if you comment this it always run hibernate.properties file. so it will connect with mysql db not h2 db.

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student();
            student.setStudentName("priya");
            session.persist(student);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();

        }
    }
}