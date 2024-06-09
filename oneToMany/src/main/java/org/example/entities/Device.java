package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "device_table")
public class Device {

    @Id @GeneratedValue
    @Column(name = "device_id")
    private long id;

    @Column(name = "device_name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_fk")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
