package io.khasang.hotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ServiceRoom")
public class ServiceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @ManyToOne (cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name="contacts")
    private Contacts contact = new Contacts();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<User> personal = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    public List<User> getPersonal() {
        return personal;
    }

    public void setPersonal(List<User> personal) {
        this.personal = personal;
    }
}
