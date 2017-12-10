package io.khasang.hotel.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<RoomService> roomServiceSet = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<RoomService> getRoomServiceSet() {
        return roomServiceSet;
    }

    public void setRoomServiceSet(Set<RoomService> roomServiceSet) {
        this.roomServiceSet = roomServiceSet;
    }
}
