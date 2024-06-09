package org.example;

import org.example.entities.Device;
import org.example.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Device.class);
        config.addAnnotatedClass(org.example.entities.Person.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();


            Device mobile = new Device();
            mobile.setName("mobile");

            Device laptop = new Device();
            laptop.setName("laptop");

            Device fridge = new Device();
            fridge.setName("fridge");

            Person p1 = new Person();
            p1.setName("abc");

            Person p2 = new Person();
            p2.setName("pqr");

            mobile.setPerson(p1);
            laptop.setPerson(p2);
            fridge.setPerson(p1);

//            session.persist(mobile);
//            session.persist(laptop);
//            session.persist(fridge);

            List p1_device  = new ArrayList();
            p1_device.add(mobile);
            p1_device.add(fridge);

            List p2_device = new ArrayList();
            p2_device.add(laptop);

            p1.setDevice(p1_device);
            p2.setDevice(p2_device);

            session.persist(p1);
            session.persist(p2);

            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}