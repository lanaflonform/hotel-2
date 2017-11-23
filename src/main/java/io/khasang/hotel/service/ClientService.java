package io.khasang.hotel.service;

import io.khasang.hotel.entity.Client;
import java.util.List;

public interface ClientService {
    /**
     * method for receiving all clients
     * @return
     */
    List<Client> getAllClients();

    /**
     * @param id = client id
     * @return Client by id
     */
    Client getClientById(long id);

    /**
     * @param client  - client that should be added to DB
     * @return client
     */
    Client addClient(Client client);

    /**
     * @param client  - client that should be update to DB
     * @return client
     */
    Client updateClient(Client client);

    /**
     * @param name - familie of client
     * @return list od clients with specify name = name
     */
    List<Client> getClientByFamilie(String name);
    /**
     * @param id - client id for remove
     * @return deleted client
     */
    Client deleteClient(long id);
}
