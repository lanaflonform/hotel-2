package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.TaskDao;
import io.khasang.hotel.entity.Task;

import java.util.List;

public class TaskDaoImpl extends BasicDaoImpl<Task> implements TaskDao {

    public TaskDaoImpl(Class<Task> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Task> getTaskByName(String name) {
        return (List<Task>) sessionFactory.getCurrentSession().
                createQuery("from Task as t where t.name = ?").setParameter(0, name).list();
    }
}
