package io.khasang.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private List<Photo> photoPassport;
    @OneToOne
    @JoinColumn(name = "photoLogin")
    private Photo photoLogin;
    @Column(name = "dateOfBirth",columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    @Column(columnDefinition = "DATE")
    private LocalDate registered = LocalDate.now();
    @Column(name = "coupon")
    private String coupon;
    @Column(name = "level")
    private int level;
    @OneToOne (cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name="contacts")
    private Contacts contact = new Contacts();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public List<Photo> getPhotoPassport() {
        return photoPassport;
    }

    public void setPhotoPassport(List<Photo> photoPassport) {
        this.photoPassport = photoPassport;
    }

    public Photo getPhotoLogin() {
        return photoLogin;
    }

    public void setPhotoLogin(Photo photoLogin) {
        this.photoLogin = photoLogin;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }
}
