package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Role;
import io.khasang.hotel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role getRoleById(@PathVariable(value = "id") String id) {
        return roleService.getRoleById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @ResponseBody
    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public List<Role> getRolesByName(@PathVariable("name") String name) {
        return roleService.getRolesByName(name);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Role deleteRole(@RequestParam(value = "id") String id) {
        return roleService.deleteRole(Long.parseLong(id));
    }

}
