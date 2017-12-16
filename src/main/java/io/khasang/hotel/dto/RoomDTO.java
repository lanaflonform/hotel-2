package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Room;
import io.khasang.hotel.entity.RoomService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoomDTO {
    private long id;
    private int number;
    private Set<RoomServiceDTO> roomServiceSet = new HashSet<>();

    public Set<RoomDTO> getRoomDTO(Set<Room> roomSet) {
        Set<RoomDTO> roomDTOSet = new HashSet<>();

        for(Room room : roomSet) {
            Set<RoomServiceDTO> roomServiceDTOS = new HashSet<>();
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setId(room.getId());
            roomDTO.setNumber((room.getNumber()));


            for (RoomService roomService : room.getRoomServiceSet()) {
                RoomServiceDTO roomServiceDTO = new RoomServiceDTO();
                roomServiceDTO.setName(roomService.getName());
                roomServiceDTO.setDescription(roomService.getDescription());
                roomServiceDTO.setId(roomService.getId());
                roomServiceDTOS.add(roomServiceDTO);
            }

            roomDTO.setRoomServiceSet(roomServiceDTOS);
            roomDTOSet.add(roomDTO);
        }
        return roomDTOSet;
    }

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

    public Set<RoomServiceDTO> getRoomServiceSet() {
        return roomServiceSet;
    }

    public void setRoomServiceSet(Set<RoomServiceDTO> roomServiceSet) {
        this.roomServiceSet = roomServiceSet;
    }
}
