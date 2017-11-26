package io.khasang.hotel.controller;

import io.khasang.hotel.entity.User;
import io.khasang.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/get/login/{login}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public User getUserByLogin(@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(Long.parseLong(id));
    }
}
