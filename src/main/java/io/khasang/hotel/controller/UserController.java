package io.khasang.hotel.controller;

import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getPage() {
        return "users";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Set<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO getUserById(@PathVariable(value = "id") String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/get/login/{login}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public UserDTO getUserByLogin(@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public UserDTO deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(Long.parseLong(id));
    }
}
