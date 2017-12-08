package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.entity.User;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User getByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().
                createQuery("from User as u where u.login = ?").setParameter(0, login).uniqueResult();
    }

    @Override
    public User getByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().
                createQuery("from User as u where u.email = ?").setParameter(0, email).uniqueResult();
    }
}
