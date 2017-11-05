package io.khasang.hotel.controller;

import io.khasang.hotel.model.Message;
import io.khasang.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    private final MessageService messageService;

//    // связывание контекста с конфигурационным xml файлом
//    ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring-context.xml");

    @Autowired
    public AppController(MessageService messageService) {
        this.messageService = messageService;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model) {
     //   model.addAttribute("name", "Алексей Листаренков");
        model.addAttribute("name", messageService.getMessageInfo("Алексей Листаренков")); // messageService берем напрямую из облака бинов
        return "hello";
    }

    @RequestMapping("/help")
    public void showHelp(Model model){
        model.addAttribute("", messageService.getMessageInfo("Help"));
    }

    @ResponseBody //указывает, что при запросе на адрес /message тело ответа должно соответствовать
    // набору данных, предоставленных классом Message
    @RequestMapping("/message")
    public Message getMessage() {
        return null;
    }
}
