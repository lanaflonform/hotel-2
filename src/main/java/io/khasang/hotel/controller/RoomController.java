package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Room;
import io.khasang.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Room getRoomById(@PathVariable(value = "id") String id) {
        return roomService.getRoomById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    @ResponseBody
    @RequestMapping(value = "/get/number/{number}", method = RequestMethod.GET)
    public Room getRoomByNum(@PathVariable("number") int number) {
        return roomService.getRoomByNum(number);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Room deleteRoom(@RequestParam(value = "id") String id) {
        return roomService.deleteRoom(Long.parseLong(id));
    }
}
