package io.khasang.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Set<Phone> phoneSet = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.ALL})
    private List<Address> addressList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Set<Mail> mailSet = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Set<Link> linkSet = new HashSet<>();

    public Contacts() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Phone> getPhoneSet() {
        return phoneSet;
    }

    public void setPhoneSet(Set<Phone> phoneSet) {
        this.phoneSet = phoneSet;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Set<Mail> getMailSet() {
        return mailSet;
    }

    public void setMailSet(Set<Mail> mailSet) {
        this.mailSet = mailSet;
    }

    public Set<Link> getLinkSet() {
        return linkSet;
    }

    public void setLinkSet(Set<Link> linkSet) {
        this.linkSet = linkSet;
    }
}
