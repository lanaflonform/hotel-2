package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.RoleDao;
import io.khasang.hotel.entity.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public Set<Role> getRolesByName(String name) {
        Set<Role> set = new HashSet<>();
        List list = (List<Role>) sessionFactory.getCurrentSession().
                createQuery("from roles as c where c.name = ?").setParameter(0, name).list();
        set.addAll(list);
        return set;
    }
}
