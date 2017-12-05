package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class AddressDTO {
    private long id;
    private String street;
    private String numberStreet;
    private List<Client> clientList = new ArrayList<>();
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO that = (AddressDTO) o;

        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        return numberStreet != null ? numberStreet.equals(that.numberStreet) : that.numberStreet == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (numberStreet != null ? numberStreet.hashCode() : 0);
        return result;
    }
}
