package io.khasang.hotel.entity;

import javax.persistence.*;
@Entity
@Table(name = "fireAlarm")
public class FireAlarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fire")
    private boolean fire;

    public FireAlarm() {
        this.fire = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }
}



