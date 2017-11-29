package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Client;
import io.khasang.hotel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    public ClientController(){}
    @RequestMapping("/")
    public String clientPage(){
        return "client";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Client getClientById(@PathVariable(value = "id") String id) {
        return clientService.getClientById(Long.parseLong(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClientsByFamilie(@PathVariable("name") String name) {
        return clientService.getClientByFamilie(name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Client deleteClient(@RequestParam(value = "id") String id) {
        return clientService.deleteClient(Long.parseLong(id));
    }
}
