package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class BtechSemester implements Semester{

    @Override
    public String getSemesterNo() {
        return "6";
    }

    @Override
    public String getSubjects() {
        return "FSD, DAIE, LT, AOS, DAPython";
    }
}
