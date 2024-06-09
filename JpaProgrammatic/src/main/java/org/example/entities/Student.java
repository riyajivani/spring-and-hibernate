package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
    @Id
    private long sid;

    @Column(name = "sname")
    private String studentName;

    public long getId() {
        return sid;
    }

    public void setId(long id) {
        this.sid = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
