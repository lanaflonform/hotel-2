package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.ClientDao;
import io.khasang.hotel.entity.Client;

import java.util.List;

public class ClientDaoImpl extends BasicDaoImpl<Client> implements ClientDao{


    public ClientDaoImpl(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Client> getClientsByFamilie(String name) {
        return (List<Client>) sessionFactory.getCurrentSession().
                createQuery("from Client as c where c.name = ?").setParameter(0, name).list();
    }
}
