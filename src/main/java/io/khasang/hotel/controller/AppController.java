package io.khasang.hotel.controller;

import io.khasang.hotel.model.CreateTable;
import io.khasang.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

@Controller
public class AppController {
    private final MessageService messageService;
    private final CreateTable createTable;

    @Autowired
    public AppController(MessageService messageService, CreateTable createTable) {
        this.messageService = messageService;
        this.createTable = createTable;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage() {
        return "hello";
    }

    @RequestMapping("/cat")
    public String catPage() {
        return "cat";
    }

    @RequestMapping("/room")
    public String roomPage() {
        return "room";
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "status";
    }

    @ResponseBody
    @RequestMapping("/user")
    public String userPage() {
        return getUserName();
    }

    @ResponseBody
    @RequestMapping("/admin")
    public String adminPage() {
        return getUserName();
    }

    @ResponseBody
    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public String getPassword(@PathVariable("password") String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    private String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
