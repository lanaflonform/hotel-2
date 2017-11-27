package io.khasang.hotel.service;

import io.khasang.hotel.entity.Room;

import java.util.List;

public interface RoomService {
    /**
     * method for receiving all rooms
     *
     * @return all rooms
     */
    List<Room> getAllRooms();

    /**
     * @param id = room id
     * @return Room by id
     */
    Room getRoomById(long id);

    /**
     * @param room - room that should be added to DB
     * @return room
     */
    Room addRoom(Room room);

    /**
     * @param room - room that should be updated to DB
     * @return room
     */
    Room updateRoom(Room room);

    /**
     * @param number - name of rooms
     * @return list of rooms with specify number
     */
    Room getRoomByNum(int number);

    /**
     * @param id - room id for remove
     * @return  deleted room
     * */
    Room deleteRoom(long id);
}
