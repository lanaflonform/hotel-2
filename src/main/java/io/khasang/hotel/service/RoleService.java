package io.khasang.hotel.service;

import io.khasang.hotel.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * method for receiving all roles
     *
     * @return all roles
     */
    List<Role> getAllRoles();

    /**
     * @param id = role id
     * @return Role by id
     */
    Role getRoleById(long id);

    /**
     * @param role - role that should be added to DB
     * @return role
     */
    Role addRole(Role role);

    /**
     * @param role - role that should be updated to DB
     * @return role
     */
    Role updateRole(Role role);

    /**
     * @param name - name of roles
     * @return list of roles with specify name
     */
    List<Role> getRolesByName(String name);

    /**
     * @param id - role id for remove
     * @return deleted role
     */
    Role deleteRole(long id);
}
