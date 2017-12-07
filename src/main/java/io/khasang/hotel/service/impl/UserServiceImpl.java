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
    public Set<UserDTO> getAll() {
        return UserDTO.getSet(userDao.getSet());
    }

    @Override
    public UserDTO delete(Long id) {
        return UserDTO.build(userDao.delete(userDao.getById(id)));
    }

    @Override
    public UserDTO getByLogin(String login) { return UserDTO.build(userDao.getByLogin(login)); }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return UserDTO.build(userDao.update(userDTO.toUser()));
    }

    @Override
    public UserDTO add(UserDTO userDTO) {
        return UserDTO.build(userDao.add(userDTO.toUser()));
    }

    @Override
    public UserDTO getById(Long id) {
        return UserDTO.build(userDao.getById(id));
    }
}
