package org.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jdk.jfr.Label;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //@Lazy
public class BtechSemester implements Semester{

    public BtechSemester() {
        System.out.println("btechsemester constructor called\n");
    }

    @PostConstruct
    public void doInitialization(){
        System.out.println("Btechsemester doinitialization()");
    }

    @PreDestroy
    public void  doCleanUp(){
        System.out.println("Btechsemester doCleanUp()");
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
