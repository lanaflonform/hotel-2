package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Client;

import java.util.List;

public interface ClientDao extends BasicDao<Client> {

    List<Client> getClientsByFamilie(String name);

}
