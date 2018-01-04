package io.khasang.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "securityAlarm")
public class SecurityAlarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "alarm")
    private boolean alarm;

    public SecurityAlarm() {
        this.alarm = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}
