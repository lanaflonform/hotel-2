package io.khasang.hotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Set<Phone> phoneSet = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private ArrayList<Address>  addressList = new ArrayList<>();
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

    public void addPhone(Phone phone){
        phoneSet.add(phone);
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public void addAddress(Address address){
        addressList.add(address);
    }

    public Set<Mail> getMailSet() {
        return mailSet;
    }

    public void setMailSet(Set<Mail> mailSet) {
        this.mailSet = mailSet;
    }

    public void addMail(Mail mail){
        mailSet.add(mail);
    }

    public Set<Link> getLinkSet() {
        return linkSet;
    }

    public void setLinkSet(Set<Link> linkSet) {
        this.linkSet = linkSet;
    }
    public void addLink(Link link){
        linkSet.add(link);
    }
}
