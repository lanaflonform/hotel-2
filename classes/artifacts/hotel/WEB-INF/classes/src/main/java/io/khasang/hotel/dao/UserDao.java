package io.khasang.hotel.dao;

import io.khasang.hotel.entity.User;

public interface UserDao extends BasicDao<User> {
    /**
     * method for receiving user by login
     *
     * @param login - login of user
     * @return user entity with specify login
     */
    User getByLogin(String login);

    /**
     * method for receiving user by login
     *
     * @param email - email of user
     * @return user entity with specify email
     */
    User getByEmail(String email);
}
