package io.khasang.hotel.controller;

import io.khasang.hotel.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    private final Message message;

    @Autowired
    public AppController(Message message){
        this.message = message;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model){
        model.addAttribute("hello", "Hello");
        return "hello";
    }
}
