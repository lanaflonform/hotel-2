package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.ClientDao;
import io.khasang.hotel.entity.Client;

import java.util.List;

public class ClientDaoImpl extends BasicDaoImpl<Client> implements ClientDao{


    public ClientDaoImpl(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Client> getClientsByFamilie(String family) {
        return (List<Client>) sessionFactory.getCurrentSession().
                createQuery("from Client as c where c.family = ?").setParameter(0, family).list();
    }
}
