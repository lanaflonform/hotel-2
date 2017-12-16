package io.khasang.hotel.controller;

import io.khasang.hotel.dto.RoomDTO;
import io.khasang.hotel.entity.Room;
import io.khasang.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<RoomDTO> getRooms(){
        return roomService.getSet();
    }
}
