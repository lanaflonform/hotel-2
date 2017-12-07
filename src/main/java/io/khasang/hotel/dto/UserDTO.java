package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Role;
import io.khasang.hotel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String login;
    private String password;
    private boolean enabled;
    private Set<RoleDTO> roles;

    public Set<UserDTO> getUserDTOSet(Set<User> userSet) {
        return userSet.stream().map(this::createUserDTO).collect(Collectors.toSet());
    }

    public UserDTO createUserDTO(User user) {
        // check if user deleted
        if (user == null) {
            return null;
        } else {
            return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday(),
                    user.getLogin(), user.getPassword(), user.isEnabled(), getRoleDTOSet(user));
        }
    }

    public Set<RoleDTO> getRoleDTOSet(User user) {
        return user.getRoles().stream()
                .map(role -> new RoleDTO(role.getId(), role.getName(), role.getDescription()))
                .collect(Collectors.toSet());
    }

    public User toUser() {
        return new User(id, firstName, lastName, email, birthday, login, password, enabled, getRoleSet());
    }

    private Set<Role> getRoleSet() {
        return roles.stream()
                .map(roleDTO -> new Role(roleDTO.getId(), roleDTO.getName(), roleDTO.getDescription()))
                .collect(Collectors.toSet());
    }
}
