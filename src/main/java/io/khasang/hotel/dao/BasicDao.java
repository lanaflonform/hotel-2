package io.khasang.hotel.dao;

import org.hibernate.Session;

import java.util.List;
import java.util.Set;

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
     * method for receiving all entity
     *
     * @return all entity
     */
    Set<T> getSet();

    /**
     * receive entity by id
     * @param id - entity id
     *
     * @return specify entity
     * */
    T getById(long id);

    /**
     * @param entity - entity id
     *
     * @return specify entity
     * */
    T add(T entity);

    /**
     * @param entity - entity id
     *
     * @return specify entity
     * */
    T update(T entity);

    /**
     * @param entity - entity id for remove
     * @return  deleted entity
     * */
    T delete(T entity);
}
