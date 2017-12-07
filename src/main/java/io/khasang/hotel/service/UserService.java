package io.khasang.hotel.service;

import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    /**
     * method for receiving all users
     *
     * @return all users DTO
     */
    Set<UserDTO> getAllUsers();

    /**
     * @param id = user id
     * @return User DTO by id
     */
    UserDTO getUserById(Long id);

    /**
     * @param userDTO - user DTO that should be added to DB
     * @return user DTO
     */
    UserDTO addUser(UserDTO userDTO);

    /**
     * @param userDTO - user that should be updated to DB
     * @return user DTO
     */
    UserDTO updateUser(UserDTO userDTO);

    /**
     * @param login - login of user
     * @return user DTO with specify login
     */
    UserDTO getUserByLogin(String login);

    /**
     * @param id - user id for remove
     * @return  deleted user DTO
     * */
    UserDTO deleteUser(Long id);
}
