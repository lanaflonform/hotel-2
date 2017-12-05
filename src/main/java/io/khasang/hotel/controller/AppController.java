package io.khasang.hotel.controller;

import io.khasang.hotel.model.CreateTable;
import io.khasang.hotel.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {
    private final CreateTable createTable;
    private final Message message;

    @Autowired
    public AppController(Message message, CreateTable createTable){
        this.createTable = createTable;
        this.message = message;
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model){
       // model.addAttribute("status", createTable.createTableStatus());
        return "status";
    }

    @RequestMapping("/")
    public String helloPage(Model model){
        model.addAttribute("hello", "Hello !");
        return "hello";
    }
}
