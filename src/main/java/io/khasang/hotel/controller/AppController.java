package io.khasang.hotel.controller;

import io.khasang.hotel.model.TableUtils;
import io.khasang.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private final MessageService messageService;
    private final TableUtils tableUtils;

    @Autowired
    public AppController(MessageService messageService, TableUtils tableUtils) {
        this.messageService = messageService;
        this.tableUtils = tableUtils;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", messageService.getMessageInfo("Jack Vorobei"));
        return "hello";
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model) {
        model.addAttribute("operation", "CREATE TABLE");
        model.addAttribute("status", tableUtils.createStatus());
        return "sqlStatus";
    }

    @RequestMapping("/select")
    public String tableSelectInfo(Model model) {
        model.addAttribute("operation", "SELECT");
        model.addAttribute("status", tableUtils.selectStatus());
        return "sqlStatus";
    }

    @RequestMapping("/insert")
    public String tableInsertInfo(Model model) {
        model.addAttribute("operation", "INSERT");
        model.addAttribute("status", tableUtils.insertStatus());
        return "sqlStatus";
    }

    @RequestMapping("/update")
    public String tableUpdateInfo(Model model) {
        model.addAttribute("operation", "UPDATE");
        model.addAttribute("status", tableUtils.updateStatus());
        return "sqlStatus";
    }

    @RequestMapping("/delete")
    public String tableDeleteInfo(Model model) {
        model.addAttribute("operation", "DELETE");
        model.addAttribute("status", tableUtils.deleteStatus());
        return "sqlStatus";
    }

    @RequestMapping("/selectwithjoin")
    public String tableSelectWithJoinInfo(Model model) {
        model.addAttribute("operation", "SELECT WITH JOIN");
        model.addAttribute("status", tableUtils.selectWithJoinStatus());
        return "sqlStatus";
    }

    @RequestMapping("/selectwithembeddedselect")
    public String tableSelectWithEmbeddedSelectInfo(Model model) {
        model.addAttribute("operation", "SELECT WITH EMBEDDED SELECT");
        model.addAttribute("status", tableUtils.selectWithEmbeddedSelectStatus());
        return "sqlStatus";
    }
}
