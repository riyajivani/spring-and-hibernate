package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "capital_table")
public class Capital {

    @Id
    @GeneratedValue
    @Column(name = "cid")
    private long id;

    @Column(name = "cname")
    private String cname;

    @OneToOne(mappedBy = "capital" , cascade = CascadeType.ALL)
    private State state;

    public long getId() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
