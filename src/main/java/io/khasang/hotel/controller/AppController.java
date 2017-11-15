package io.khasang.hotel.controller;

import io.khasang.hotel.model.CreateTable;
import io.khasang.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String helloPage(Model model) {
        model.addAttribute("name", messageService.getMessageInfo("Jack Vorobei"));
        return "hello";
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "status";
    }

    @ResponseBody
    @RequestMapping("/user")
    public String userPage(){
        return "user";
    }

    @ResponseBody
    @RequestMapping("/admin")
    public String adminPage(){
        return "user";
    }

}
