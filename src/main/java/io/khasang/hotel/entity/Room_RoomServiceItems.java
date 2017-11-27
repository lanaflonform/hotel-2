package io.khasang.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_roomService")
public class Room_RoomServiceItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "room_id")
    private long roomId;

    @Column(name = "roomService_Id")
    private long roomServiceId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getRoomServiceId() {
        return roomServiceId;
    }

    public void setRoomServiceId(long roomServiceId) {
        this.roomServiceId = roomServiceId;
    }
}
