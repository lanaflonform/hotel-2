package io.khasang.hotel.dto;

public class AddressDTO {
    private long id;
    private String street;
    private String numberStreet;
    private String numberHouse;

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

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO that = (AddressDTO) o;

        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (numberStreet != null ? !numberStreet.equals(that.numberStreet) : that.numberStreet != null) return false;
        return numberHouse != null ? numberHouse.equals(that.numberHouse) : that.numberHouse == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (numberStreet != null ? numberStreet.hashCode() : 0);
        result = 31 * result + (numberHouse != null ? numberHouse.hashCode() : 0);
        return result;
    }
}
