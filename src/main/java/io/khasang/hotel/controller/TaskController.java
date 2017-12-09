package io.khasang.hotel.controller;

import io.khasang.hotel.dto.TaskDTO;
import io.khasang.hotel.entity.Task;
import io.khasang.hotel.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<TaskDTO> getAllTask() {
        return taskService.getAllTask();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Task getTaskById(@PathVariable(value = "id") String id) {
        return taskService.getTaskById(Long.parseLong(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskDTO> getTaskByName(@PathVariable("name") String name) {
        return taskService.getTaskByName(name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Task deleteTask(@RequestParam(value = "id") String id) {
        return taskService.deleteTask(Long.parseLong(id));
    }
}
