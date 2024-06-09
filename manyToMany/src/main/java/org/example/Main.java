package org.example;

import org.example.entities.Certificate;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Certificate.class);
        config.addAnnotatedClass(org.example.entities.Student.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student riya = new Student();
            riya.setName("riya");

            Student shreya = new Student();
            shreya.setName("shreya");

            Student priya = new Student();
            priya.setName("priya");

            Certificate aws = new Certificate();
            aws.setCname("aws");

            Certificate java = new Certificate();
            java.setCname("java");

            Certificate vmWare = new Certificate();
            vmWare.setCname("vmWare");
//
//            Set<Certificate> riyaCertificate = new HashSet();
//            riyaCertificate.add(java);
//            riyaCertificate.add(vmWare);
//
//            Set<Certificate> shreyaCertificate = new HashSet();
//            shreyaCertificate.add(aws);
//
//            Set<Certificate> priyaCertificate = new HashSet();
//            priyaCertificate.add(aws);
//            priyaCertificate.add(java);
//            priyaCertificate.add(vmWare);
//
//            riya.setStudentCertificates(riyaCertificate);
//            shreya.setStudentCertificates(shreyaCertificate);
//            priya.setStudentCertificates(priyaCertificate);
//
//            session.persist(riya);
//            session.persist(shreya);
//            session.persist(priya);


            Set<Student> awsStudent = new HashSet();
            awsStudent.add(shreya);
            awsStudent.add(priya);


            Set<Student> javaStudent = new HashSet();
            javaStudent.add(riya);
            javaStudent.add(priya);

            Set<Student> vmWareStudent = new HashSet();
            vmWareStudent.add(riya);
            vmWareStudent.add(priya);

            aws.setStudents(awsStudent);
            java.setStudents(javaStudent);
            vmWare.setStudents(vmWareStudent);

            session.persist(aws);
            session.persist(java);
            session.persist(vmWare);



            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}