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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (!name.equals(task.name)) return false;
        if (!bid.equals(task.bid)) return false;
        if (completed != null ? !completed.equals(task.completed) : task.completed != null) return false;
        return createdAt != null ? createdAt.equals(task.createdAt) : task.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + bid.hashCode();
        result = 31 * result + (completed != null ? completed.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
