package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.entity.User;
import io.khasang.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getList();
    }

    @Override
    public User deleteUser(long id) {
        return userDao.delete(getUserById(id));
    }

    @Override
    public User getUserByLogin(String login) { return userDao.getUserByLogin(login); }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User addUser(User user) {
        return userDao.add(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getById(id);
    }
}
