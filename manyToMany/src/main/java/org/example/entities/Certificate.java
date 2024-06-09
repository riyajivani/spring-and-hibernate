package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue
    @Column(name = "cer_id")
    private long cid;

    @Column(name = "cer_name")
    private  String cname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_student_certificate", joinColumns = {@JoinColumn(name = "certificate_fk")}, inverseJoinColumns ={@JoinColumn(name = "student_fk")} )
    private Set<Student> students;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
