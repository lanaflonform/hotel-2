package io.khasang.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "family")
    private String family;
    @Column(name = "name")
    private String name;
    @Column(name = "secondname")
    private String secondName;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(name = "photoPassport")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Photo photoPassport;
    @Column(name = "photoLogin")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Photo photoLogin;
    @Column(name = "dateOfBirth",columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    @Column(columnDefinition = "DATE")
    private LocalDate registered = LocalDate.now();
    @Column(name = "coupon")
    private String coupon;
    @Column(name = "level")
    private int level;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//   // @JsonManagedReference  - сериализирует
//    private Set<Phone> phoneList = new HashSet<>();
//    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.ALL}, fetch = FetchType.EAGER)
//    private List<Address> addresses = new ArrayList<>();
    @OneToMany (cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Contacts contact = new Contacts();
}
