package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Set<UserDTO> getAllUsers() {
        return UserDTO.getUserDTOSet(userDao.getSet());
    }

    @Override
    public UserDTO deleteUser(Long id) {
        return UserDTO.buildUserDTO(userDao.delete(userDao.getById(id)));
    }

    @Override
    public UserDTO getUserByLogin(String login) { return UserDTO.buildUserDTO(userDao.getUserByLogin(login)); }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return UserDTO.buildUserDTO(userDao.update(userDTO.toUser()));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return UserDTO.buildUserDTO(userDao.add(userDTO.toUser()));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserDTO.buildUserDTO(userDao.getById(id));
    }
}
