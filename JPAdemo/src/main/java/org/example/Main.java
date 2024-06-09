package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Student;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAdemo");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Student student = new Student();
            student.setId(5);
            student.setStudentName("riya");
            em.persist(student);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}