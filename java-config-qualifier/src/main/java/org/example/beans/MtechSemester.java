package org.example.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component //@Lazy
public class MtechSemester implements Semester{

    public MtechSemester() {
        System.out.println("mtechsemester constructor called\n");
    }

    @Override
    public String getSemesterNo() {
        return "4";
    }

    @Override
    public String getSubjects() {
        return "Desertation";
    }
}
