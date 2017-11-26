package io.khasang.hotel.dao;

import io.khasang.hotel.entity.User;

public interface UserDao extends BasicDao<User> {
    User getUserByLogin(String login);
}
