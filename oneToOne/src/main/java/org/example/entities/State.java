package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "state_table")
public class State {

    @Id
    @GeneratedValue
    @Column(name = "state_id")
    private long id;
    @Column(name = "state_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "capital_fk")
    private Capital capital;
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}
