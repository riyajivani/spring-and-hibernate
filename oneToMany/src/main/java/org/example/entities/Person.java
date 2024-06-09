package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person_table")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "pid")
    private long id;

    @Column(name = "pname")
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Device> device;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevice() {
        return device;
    }

    public void setDevice(List<Device> device) {
        this.device = device;
    }
}
