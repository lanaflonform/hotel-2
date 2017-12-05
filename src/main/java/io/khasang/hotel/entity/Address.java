package io.khasang.hotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "street")
    private String street;
    @Column(name = "numberStreet")
    private String numberStreet;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "addresses")
    private List<Client> clientList = new ArrayList<>();

    public Address() {
    }
    public Address(String street, String number) {
        this.street = street;
        this.numberStreet = number;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String number) {
        this.numberStreet = number;
    }
}
