package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.entity.User;
import io.khasang.hotel.service.UserService;
import io.khasang.hotel.util.exception.NotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static io.khasang.hotel.util.ValidationUtil.checkNotFound;
import static io.khasang.hotel.util.ValidationUtil.checkNotFoundWithId;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Set<UserDTO> getAll() {
        return UserDTO.getSet(userDao.getSet());
    }

    @Override
    public UserDTO delete(Long id) throws NotFoundException {
        User user = checkNotFoundWithId(userDao.getById(id), id);
        return UserDTO.build(userDao.delete(user));
    }

    @Override
    public UserDTO getByLogin(String login) throws NotFoundException {
        User user = checkNotFound(userDao.getByLogin(login), "login=" + login);
        return UserDTO.build(user);
    }

    @Override
    public UserDTO getByEmail(String email) throws NotFoundException {
        User user = checkNotFound(userDao.getByEmail(email.replace("\"", "")), "email=" + email);
        return UserDTO.build(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) throws NotFoundException {
        User user = checkNotFoundWithId(userDao.update(userDTO.toUser()), userDTO.getId());
        return UserDTO.build(user);
    }

    @Override
    public UserDTO add(@NonNull UserDTO userDTO) {
        return UserDTO.build(userDao.add(userDTO.toUser()));
    }

    @Override
    public UserDTO getById(Long id) throws NotFoundException {
        User user = checkNotFoundWithId(userDao.getById(id), id);
        return UserDTO.build(user);
    }
}
