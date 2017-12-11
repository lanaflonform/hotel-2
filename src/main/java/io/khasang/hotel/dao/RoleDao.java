package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Role;

import java.util.Set;

public interface RoleDao extends BasicDao<Role> {
    Set<Role> getRolesByName(String name);
}
