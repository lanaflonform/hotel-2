package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Role;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoleDTO {
    private long id;
    private String name;
    private String description;
    private Set<UserDTO> users = new HashSet();

    public RoleDTO() {
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public Set<RoleDTO> getRoleDTO(Set<Role> roleSet) {
        Set<RoleDTO> roleDTOSet = new HashSet<>();
        for (Role role : roleSet) {
            roleDTOSet.add(new RoleDTO(role));
        }
        return roleDTOSet;
    }
}
