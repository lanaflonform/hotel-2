package io.khasang.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {

    @Id
    private Long id;

    @Column(name = "`number`")
    private String number;

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phone(String number) {
        this.number = number;

    }
}
