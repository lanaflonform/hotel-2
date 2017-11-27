package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.ClientDao;
import io.khasang.hotel.entity.Client;
import io.khasang.hotel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> getAllClients() {
        return clientDao.getList();
    }

    @Override
    public Client getClientById(long id) {
        return clientDao.getById(id);
    }

    @Override
    public Client addClient(Client client) {
        return clientDao.add(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.update(client);
    }

    @Override
    public List<Client> getClientByFamilie(String name) {
        return clientDao.getClientsByFamilie(name);
    }

    @Override
    public Client deleteClient(long id) {
        return clientDao.delete(getClientById(id));
    }

}
