package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.RoleDao;
import io.khasang.hotel.entity.Role;
import io.khasang.hotel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getList();
    }

    @Override
    public Role deleteRole(long id) {
        return roleDao.delete(getRoleById(id));
    }

    @Override
    public List<Role> getRolesByName(String name) {
        return roleDao.getRolesByName(name);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.update(role);
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDao.getById(id);
    }
}
