package io.khasang.hotel.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number",unique = true)
    private String number;
    @Column(name = "bed")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Bed> bed = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Photo> photoRoom = new ArrayList<>();
    @Column(name = "description")
    private String description;
    @Column(name = "comment")
    private String comment;
    @OneToOne
    @JoinColumn(name = "fire")
    private FireAlarm fire;
    @OneToOne
    @JoinColumn(name = "alarm")
    private SecurityAlarm alarm;
    @OneToOne
    @JoinColumn(name = "busy")
    private Busy busy;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "status")
    private Enum status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Bed> getBed() {
        return bed;
    }

    public void setBed(List<Bed> bed) {
        this.bed = bed;
    }

    public List<Photo> getPhotoRoom() {
        return photoRoom;
    }

    public void setPhotoRoom(List<Photo> photoRoom) {
        this.photoRoom = photoRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public FireAlarm getFire() {
        return fire;
    }

    public void setFire(FireAlarm fire) {
        this.fire = fire;
    }

    public SecurityAlarm getAlarm() {
        return alarm;
    }

    public void setAlarm(SecurityAlarm alarm) {
        this.alarm = alarm;
    }

    public Busy getBusy() {
        return busy;
    }

    public void setBusy(Busy busy) {
        this.busy = busy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
}
