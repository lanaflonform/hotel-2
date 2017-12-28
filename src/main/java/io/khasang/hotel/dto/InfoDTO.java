package io.khasang.hotel.dto;

import io.khasang.hotel.dao.UserDao;
import io.khasang.hotel.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InfoDTO {
    private Long id;
    private String hotelName;
    private String address;
    private Integer numberOfRooms;
    private Set<UserDTO> administratorHotelUsers = new HashSet<>();

    @Autowired
    private UserDao userDao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Set<UserDTO> getAdministratorHotelUsers() {
        return administratorHotelUsers;
    }

    public void setAdministratorHotelUsers(Set<UserDTO> administratorHotelUsers) {
        this.administratorHotelUsers = administratorHotelUsers;
    }

    public Set<InfoDTO> getSetDto(Set<Info> setInfo) {
        Set<InfoDTO> infoDTOSet = new HashSet<>();

        for (Info info :setInfo) {
            InfoDTO infoDTO = new InfoDTO();
            infoDTO.setId(info.getId());
            infoDTO.setAddress(info.getAddress());
            infoDTO.setHotelName(info.getHotelName());
            infoDTO.setNumberOfRooms(info.getNumberOfRooms());
            infoDTO.setAdministratorHotelUsers(UserDTO.getSet(userDao.getSet()));
            infoDTOSet.add(infoDTO);
        }

        return infoDTOSet;
    }
}
