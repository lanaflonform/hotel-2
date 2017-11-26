package io.khasang.hotel.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phone;
    private String country;
    private String city;
    private String address;
    private String postcode;
    private String passport;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(unique = true)
    private String login;

    private String password;
    private boolean enabled;
    private String roles;
}
