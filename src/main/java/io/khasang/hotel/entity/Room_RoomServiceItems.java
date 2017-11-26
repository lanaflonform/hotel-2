package io.khasang.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_roomService")
public class Room_RoomServiceItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long room_id;
    private long roomService_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public long getRoomService_id() {
        return roomService_id;
    }

    public void setRoomService_id(long roomService_id) {
        this.roomService_id = roomService_id;
    }
}
