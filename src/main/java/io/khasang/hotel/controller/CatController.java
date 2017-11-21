package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Cat;
import io.khasang.hotel.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat getCatById(@PathVariable(value = "id") String id) {
        return catService.getCatById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Cat updateCat(@RequestBody Cat cat) {
        return catService.updateCat(cat);
    }

    @ResponseBody
    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public List<Cat> getCatsByName(@PathVariable("name") String name) {
        return catService.getCatsByName(name);
    }

    // localhost:8080/cat/delete?id=5
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Cat deleteCat(@RequestParam(value = "id") String id) {
        return catService.deleteCat(Long.parseLong(id));
    }

}
