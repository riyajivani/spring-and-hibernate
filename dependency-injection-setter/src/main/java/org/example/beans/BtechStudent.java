package org.example.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BtechStudent implements Student{

    Semester studentSemester;

    @Autowired //we can use both constructor as well as setter injection
    BtechStudent(Semester studentSemester){
        this.studentSemester = studentSemester;
    }
    @Override
    public String getCurrentStatus() {
        return this + " is studying the following subjects " + studentSemester.getSubjects() + " in semester " + studentSemester.getSemesterNo();
    }

    @Autowired
    public void setStudentSemester(Semester studentSemester) {
        System.out.println("setStudentSemester called\n");
        this.studentSemester = studentSemester;
    }
}

