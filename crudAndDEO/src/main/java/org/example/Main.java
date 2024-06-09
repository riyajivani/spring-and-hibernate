package org.example;


import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import  org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

            Configuration config = new Configuration();
            config.addAnnotatedClass(org.example.entities.Student.class);
            SessionFactory sessionFactory = config.buildSessionFactory();

            StudentDao studentDao = new StudentDaoImpl(sessionFactory);

            Student student1 = new Student();
            student1.setId(1);
            student1.setStudentName("riya");
            Student student2 = new Student();
            student2.setId(2);
            student2.setStudentName("Hetvi");

            System.out.println("adding student "+ student1);
            System.out.println("adding student "+ student2);
            studentDao.saveStudent(student1);
            studentDao.saveStudent(student2);

            List<Student> students = studentDao.getAllStudent();
            System.out.println("Students: "+students.toString());

            Student studentToUpdate =studentDao.getStudentById(1);
            System.out.println("Updating student: "+ studentToUpdate);

            if(studentToUpdate !=null){
                studentToUpdate.setStudentName("priya");
                studentDao.updateStudent(studentToUpdate);
            }

            Student updateStudent = studentDao.getStudentById(1);
            System.out.println("Updated student: "+ updateStudent);

            studentDao.deleteStudent(2);
            System.out.println("Deleting student with id= "+2);
            List<Student> studentAfterDelete = studentDao.getAllStudent();
            System.out.println("Students: "+ studentAfterDelete.toString());

            sessionFactory.close();

    }
}