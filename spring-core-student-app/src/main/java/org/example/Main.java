package org.example;

import org.example.beans.BtechStudent;
import org.example.beans.Student;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);   used with AppConfig class(anotation method)

//        Student student1 = appContext.getBean(Student.class);
//        //Student student1 = (Student) appContext.getBean("BtechStudent");
//        System.out.println(student1.getCurrentStatus());
//
//        Student student2 = appContext.getBean(BtechStudent.class);
//        System.out.println(student2.getCurrentStatus());



//        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        Student student1 = (Student) appContext.getBean("btechStudentBean");
//        Student student2 = (Student) appContext.getBean("btechStudentBean");
//
//        System.out.println(student1.getCurrentStatus());
//        System.out.println(student2.getCurrentStatus()); // both obj is same in Singlton scope



        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student1 = appContext.getBean(Student.class);
        System.out.println(student1.getCurrentStatus());
        Student student2 = appContext.getBean(BtechStudent.class);
        System.out.println(student2.getCurrentStatus());


    }
}