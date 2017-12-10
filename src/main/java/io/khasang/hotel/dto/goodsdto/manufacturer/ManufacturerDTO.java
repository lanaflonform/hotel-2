package io.khasang.hotel.dto.goodsdto.manufacturer;

import java.util.List;

public class ManufacturerDTO {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<PersonDTO> contactListDTO;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PersonDTO> getContactListDTO() {
        return contactListDTO;
    }

    public void setContactListDTO(List<PersonDTO> contactList) {
        this.contactListDTO = contactList;
    }
}
