package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Role;
import io.khasang.hotel.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDTO {
    private long id;
    private String name;
    private String login;
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public Set<UserDTO> getUserDTO(Set<User> userSet) {
        Set<UserDTO> userDTOSet = new HashSet<>();

        for (User user : userSet) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setLogin(user.getLogin());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());

            Set<RoleDTO> roleDTOSet = new HashSet<>();
            for (Role role : user.getRoles()) {
                roleDTOSet.add(new RoleDTO(role));
            }
            userDTO.setRoles(roleDTOSet);

            userDTOSet.add(userDTO);
        }
        return userDTOSet;
    }
}
