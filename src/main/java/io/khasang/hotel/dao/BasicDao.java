package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * method for receiving all entity
     *
     * @return all entity
     */
    List<T> getList();

    /**
     * receive entity by id
     * @param id - entity id
     *
     * @return specify entity
     * */
    T getById(long id);
}
