package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Role;

import java.util.List;

public interface RoleDao extends BasicDao<Role> {
    List<Role> getRolesByName(String name);
}
