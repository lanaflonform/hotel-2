package io.khasang.hotel.controller;

import io.khasang.hotel.dto.InfoDTO;
import io.khasang.hotel.entity.Info;
import io.khasang.hotel.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<InfoDTO> getAllInfo() {
        return infoService.getAllInfo();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Info getInfoById(@PathVariable(value = "id") String id) {
        return infoService.getInfoById(Long.parseLong(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Info addInfo(@RequestBody Info info) {
        return infoService.addInfo(info);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Info updateInfo(@RequestBody Info info) {
        return infoService.updateInfo(info);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Info deleteInfo(@RequestParam(value = "id") String id) {
        return infoService.deleteInfo(Long.parseLong(id));
    }
}
