package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "sid")
    private long id;

    @Column(name = "sname")
    private  String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_student_certificate", joinColumns = {@JoinColumn(name = "student_fk")}, inverseJoinColumns ={@JoinColumn(name = "certificate_fk")} )
    private Set<Certificate> studentCertificates;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Certificate> getStudentCertificates() {
        return studentCertificates;
    }

    public void setStudentCertificates(Set<Certificate> studentCertificates) {
        this.studentCertificates = studentCertificates;
    }
}
