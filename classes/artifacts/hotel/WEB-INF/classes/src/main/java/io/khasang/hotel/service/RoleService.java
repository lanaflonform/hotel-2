package io.khasang.hotel.service;

import io.khasang.hotel.dto.RoleDTO;
import io.khasang.hotel.entity.Role;

import java.util.Set;

public interface RoleService {
    /**
     * method for receiving all roles
     *
     * @return all roles DTO
     */
    Set<RoleDTO> getAllRoles();

    /**
     * @param id = role id
     * @return role DTO by id
     */
    Role getRoleById(long id);

    /**
     * @param role - role DTO that should be added to DB
     * @return role DRO
     */
    Role addRole(Role role);

    /**
     * @param role - role that should be updated to DB
     * @return role DTO
     */
    Role updateRole(Role role);

    /**
     * @param name - name of roles
     * @return list of roles with specify name
     */
    Set<RoleDTO> getRolesByName(String name);

    /**
     * @param id - role id for remove
     * @return deleted role
     */
    Role deleteRole(long id);
}
