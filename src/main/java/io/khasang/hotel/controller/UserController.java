package io.khasang.hotel.controller;

import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.service.UserService;
import io.khasang.hotel.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Set<UserDTO> getAll() {
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/users", params = "login", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public UserDTO getByLogin(@RequestParam String login, HttpServletResponse response) {
        try {
            return userService.getByLogin(login);
        } catch (NotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/users", params = "email", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public UserDTO getByEmail(@RequestParam String email, HttpServletResponse response) {
        try {
            return userService.getByEmail(email);
        } catch (NotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @RequestMapping(value = "/users/page", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getPage() {
        return "users";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO getById(@PathVariable(value = "id") String id, HttpServletResponse response) {
        try {
            return userService.getById(Long.parseLong(id));
        } catch (NotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());

        } catch (NumberFormatException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public UserDTO add(@RequestBody UserDTO user, HttpServletResponse response) {
        response.setStatus(HttpStatus.CREATED.value());
        return userService.add(user);
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public UserDTO update(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            return userService.update(user);
        } catch (NotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public UserDTO delete(@PathVariable String id, HttpServletResponse response) {
        try {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return userService.delete(Long.parseLong(id));
        } catch (NotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (NumberFormatException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return null;
    }
}
