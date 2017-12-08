package io.khasang.hotel.service;

import io.khasang.hotel.dto.UserDTO;

import java.util.Set;

public interface UserService {
    /**
     * method for receiving all users
     *
     * @return all users DTO
     */
    Set<UserDTO> getAll();

    /**
     * method for receiving user by id
     *
     * @param id - user id
     * @return user DTO by id
     */
    UserDTO getById(Long id);

    /**
     * method for add user to DB
     *
     * @param userDTO - user DTO that should be added to DB
     * @return added user DTO
     */
    UserDTO add(UserDTO userDTO);

    /**
     * method for update user in DB
     *
     * @param userDTO - user DTO that should be updated in DB
     * @return updated user DTO
     */
    UserDTO update(UserDTO userDTO);

    /**
     * method for receiving user by login
     *
     * @param login - login of user
     * @return user DTO with specify login
     */
    UserDTO getByLogin(String login);

    /**
     * method for receiving user by email
     *
     * @param email - email of user
     * @return user DTO with specify email
     */
    UserDTO getByEmail(String email);

    /**
     * method for delete user from DB
     *
     * @param id - user id
     * @return  deleted user DTO
     * */
    UserDTO delete(Long id);
}
