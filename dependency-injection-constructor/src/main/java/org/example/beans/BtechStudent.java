package org.example.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BtechStudent implements Student{

    Semester studentSemester;

    BtechStudent(Semester studentSemester){
        this.studentSemester = studentSemester;
    }
    @Override
    public String getCurrentStatus() {

        return this + " is studying the following subjects " + studentSemester.getSubjects() + " in semester " + studentSemester.getSemesterNo();
    }
}
