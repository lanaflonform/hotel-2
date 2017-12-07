package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.entity.User;
import io.khasang.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDTO userDTO;

    @Override
    public Set<UserDTO> getAllUsers() {
        return userDTO.getUserDTOSet(userDao.getSet());
    }

    @Override
    public UserDTO deleteUser(Long id) {
        return userDTO.createUserDTO(userDao.delete(userDao.getById(id)));
    }

    @Override
    public UserDTO getUserByLogin(String login) { return userDTO.createUserDTO(userDao.getUserByLogin(login)); }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return userDTO.createUserDTO(userDao.update(userDTO.toUser()));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return userDTO.createUserDTO(userDao.add(userDTO.toUser()));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userDTO.createUserDTO(userDao.getById(id));
    }
}
