package org.example;

import org.example.entities.Capital;
import org.example.entities.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Capital.class);
        config.addAnnotatedClass(org.example.entities.State.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();

            Capital gandhinagar = new Capital();
            gandhinagar.setCname("Gandhinagar");

            State Gujarat = new State();
            Gujarat.setName("Gujarat");
            Gujarat.setCapital(gandhinagar);

            session.persist(Gujarat);



            Capital Mumbai = new Capital();
            Mumbai.setCname("Mumbai");

            State maharashtra = new State();
            maharashtra.setName("Maharashtra");
            maharashtra.setCapital(Mumbai);

            Mumbai.setState(maharashtra);

            session.persist(Mumbai);


            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();

        }


    }
}