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
    public Set<UserDTO> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO getById(@PathVariable(value = "id") String id) {
        return userService.getById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/get/login/{login}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public UserDTO getByLogin(@PathVariable("login") String login) {
        return userService.getByLogin(login);
    }

    @ResponseBody
    @RequestMapping(value = "/get/email", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public UserDTO getByEmail(@RequestBody String email) {
        return userService.getByEmail(email);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public UserDTO add(@RequestBody UserDTO user) {
        return userService.add(user);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public UserDTO update(@RequestBody UserDTO user) {
        return userService.update(user);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
