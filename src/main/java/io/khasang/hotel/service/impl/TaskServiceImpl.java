package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.TaskDao;
import io.khasang.hotel.dto.TaskDTO;
import io.khasang.hotel.entity.Task;
import io.khasang.hotel.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("TaskService")
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskDTO taskDTO;

    @Override
    public Set<TaskDTO> getAllTask() {
        return taskDTO.getSetDTO(taskDao.getSet());
    }

    @Override
    public Task getTaskById(long id) {
        return taskDao.getById(id);
    }

    @Override
    public Task addTask(Task task) {
        return taskDao.add(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskDao.update(task);
    }

    @Override
    public List<TaskDTO> getTaskByName(String name) {
        return taskDTO.getListDTO(taskDao.getTaskByName(name));
    }

    @Override
    public Task deleteTask(long id) {
        return taskDao.delete(getTaskById(id));
    }
}
