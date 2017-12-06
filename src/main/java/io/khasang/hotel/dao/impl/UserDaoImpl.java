package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.entity.User;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User getUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().
                createQuery("from User as u where u.login = ?").setParameter(0, login).uniqueResult();
    }
}
