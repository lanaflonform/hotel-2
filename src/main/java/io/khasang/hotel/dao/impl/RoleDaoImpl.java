package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.RoleDao;
import io.khasang.hotel.entity.Role;

import java.util.List;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Role> getRolesByName(String name) {
        return (List<Role>) sessionFactory.getCurrentSession().
                createQuery("from Role as c where c.name = ?").setParameter(0, name).list();
    }
}
