package org.example.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BtechStudent implements Student{

    Semester studentSemester;

//    @Autowired //we can use both constructor as well as setter injection
//    BtechStudent(@Qualifier("mtechSemester") Semester studentSemester){
//
//        System.out.println(" btechstudent constructor called");
//        this.studentSemester = studentSemester;
//    }


    public BtechStudent() {
        System.out.println(" btechstudent constructor called");
    }

    @Override //@Lazy
    public String getCurrentStatus() {
        return this + " is studying the following subjects " + studentSemester.getSubjects() + " in semester " + studentSemester.getSemesterNo();
    }

    @Autowired
    public void setStudentSemester(@Qualifier("btechSemester") Semester studentSemester) {
        System.out.println("setStudentSemester called\n");
        this.studentSemester = studentSemester;
    }
}
