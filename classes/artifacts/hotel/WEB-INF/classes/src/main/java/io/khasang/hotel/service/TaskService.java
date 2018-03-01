package io.khasang.hotel.service;

import io.khasang.hotel.entity.Task;

import java.util.List;

public interface TaskService {

    /**
     * method for receiving all task
     *
     * @return all task
     */
    List<Task> getAllTask();

    /**
     * @param id = task id
     * @return task by id
     */
    Task getTaskById(long id);

    /**
     * @param task - task that should be added to DB
     * @return task
     */
    Task addTask(Task task);


    /**
     * @param task - task that should be updated to DB
     * @return task
     */
    Task updateTask(Task task);

    /**
     * @param name - name of tasks
     * @return list of tasks with specify name
     */
    List<Task> getTaskByName(String name);

    /**
     * @param id - task id for remove
     * @return  deleted task
     * */
    Task deleteTask(long id);
}
