package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Task;

import java.util.List;

public interface TaskDao extends BasicDao<Task> {

    /**
     * @param name - name of user
     *
     * @return list of tasks with specify name
     * */
    List<Task> getTaskByName(String name);
}
