package io.khasang.hotel.service;

import io.khasang.hotel.entity.User;

import java.util.List;

public interface UserService {
    /**
     * method for receiving all users
     *
     * @return all users
     */
    List<User> getAllUsers();

    /**
     * @param id = user id
     * @return User by id
     */
    User getUserById(long id);

    /**
     * @param user - user that should be added to DB
     * @return user
     */
    User addUser(User user);

    /**
     * @param user - cat that should be updated to DB
     * @return user
     */
    User updateUser(User user);

    /**
     * @param login - login of user
     * @return user with specify login
     */
    User getUserByLogin(String login);

    /**
     * @param id - user id for remove
     * @return  deleted user
     * */
    User deleteUser(long id);
}
