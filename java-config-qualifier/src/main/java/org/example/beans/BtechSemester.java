package org.example.beans;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component //@Lazy
public class BtechSemester implements Semester{

    public BtechSemester() {
        System.out.println("btechsemester constructor called\n");
    }

    @Override
    public String getSemesterNo() {
        return "6";
    }

    @Override
    public String getSubjects() {
        return "FSD, DAIE, LT, AOS, DAPython";
    }
}
