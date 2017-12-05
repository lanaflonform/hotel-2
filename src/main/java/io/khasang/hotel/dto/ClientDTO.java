package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Address;
import io.khasang.hotel.entity.Client;
import io.khasang.hotel.entity.Phone;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component
public class ClientDTO {
    private long id;
    private String family;
    private String name;
    private String secondName;
    private LocalDate dateOfBirth;
    private int level;
    private Set<Phone> phoneList;
    private List<AddressDTO> addresses = new ArrayList();

    public List<ClientDTO> getClientDTO(List<Client> clientList) {
        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client client: clientList) {
            List<AddressDTO> addressDTOS = new ArrayList<>();
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(client.getId());
            clientDTO.setFamily(client.getFamily());
            clientDTO.setName(client.getName());
            clientDTO.setSecondName(client.getSecondName());
            clientDTO.setDateOfBirth(client.getDateOfBirth());
            clientDTO.setLevel(client.getLevel());
            clientDTO.setPhoneList(client.getPhoneList());

            for (Address address : client.getAddresses()) {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setId(address.getId());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setNumberStreet(address.getNumberStreet());
                addressDTOS.add(addressDTO);
            }
            clientDTO.setAddresses(addressDTOS);
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Set<Phone> phoneList) {
        this.phoneList = phoneList;
    }
    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
