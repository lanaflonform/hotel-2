package io.khasang.hotel.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String bid;

    @Column(columnDefinition = "DATE")
    private LocalDate completed;

    @Column(name = "created_at", columnDefinition = "DATE")
    private LocalDate createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String request) {
        this.bid = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCompleted() {
        return completed;
    }

    public void setCompleted(LocalDate completed) {
        this.completed = completed;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
