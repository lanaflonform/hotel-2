package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Client;
import io.khasang.hotel.entity.User;

import java.util.List;

public interface ClientDao extends BasicDao<Client> {
    /**
     * method for receiving user by Family
     *
     * @param name - family + name + secondName of client
     * @return List client entity
     */
    List<Client> getClientsByFamily(String name);
    /**
     * method for receiving client by login
     *
     * @param login - login of client
     * @return client entity with specify login
     */
    Client getByLogin(String login);

}
