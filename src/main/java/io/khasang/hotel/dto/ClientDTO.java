package io.khasang.hotel.dto;

import io.khasang.hotel.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDTO {
    private long id;
    private String family;
    private String name;
    private String secondName;
    private String login;
    private String password;
    private Photo photoLogin;
    private LocalDate dateOfBirth;
    private LocalDate registered = LocalDate.now();
    private String coupon;
    private int level;
    private Contacts contact = new Contacts();
    private List<PhotoDTO> photoPassport = new ArrayList<>();

    public List<ClientDTO> getClientDTO(List<Client> clientList) {
        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client client : clientList) {
            List<PhotoDTO> photoDTOS = new ArrayList<>();

            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(clientDTO.getId());
            clientDTO.setFamily(clientDTO.getFamily());
            clientDTO.setName(clientDTO.getName());
            clientDTO.setSecondName(clientDTO.getSecondName());
            clientDTO.setLogin(clientDTO.getLogin());
            clientDTO.setPassword(clientDTO.getPassword());
            clientDTO.setPhotoLogin(clientDTO.getPhotoLogin());
            clientDTO.setDateOfBirth(clientDTO.getDateOfBirth());
            clientDTO.setRegistered(clientDTO.getRegistered());
            clientDTO.setCoupon(clientDTO.getCoupon());
            clientDTO.setLevel(clientDTO.getLevel());
            clientDTO.setContact(clientDTO.getContact());
            for (Photo photo : client.getPhotoPassport()) {
                PhotoDTO photoDTO = new PhotoDTO();
                photoDTO.setId(photo.getId());
                photoDTO.setUrl(photo.getUrl());
                photoDTOS.add(photoDTO);
            }
            clientDTO.setPhotoPassport(photoDTOS);
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
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

    public List<PhotoDTO> getPhotoPassport() {
        return photoPassport;
    }

    public void setPhotoPassport(List<PhotoDTO> photoPassport) {
        this.photoPassport = photoPassport;
    }
}
