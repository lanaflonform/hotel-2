package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.ContactsDao;
import io.khasang.hotel.dto.ContactsDTO;
import io.khasang.hotel.entity.Contacts;
import io.khasang.hotel.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private ContactsDTO contactsDTO;

    @Override
    public Set<ContactsDTO> getAllContacts() {
        return contactsDTO.getContactsDTO(contactsDao.getSet());
    }

    @Override
    public Contacts getContactsById(long id) {
        return contactsDao.getById(id);
    }

    @Override
    public Contacts addContacts(Contacts contacts) {
        return contactsDao.add(contacts);
    }

    @Override
    public Contacts updateContacts(Contacts contact) {
        return contactsDao.update(contact);
    }

    @Override
    public Contacts deleteContacts(long id) {
        return contactsDao.delete(getContactsById(id));
    }
}
