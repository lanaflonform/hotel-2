package io.khasang.hotel.service;

import io.khasang.hotel.dto.ContactsDTO;
import io.khasang.hotel.entity.Contacts;

import java.util.Set;

public interface ContactsService {
    /**
     * method for receiving all contacts
     * @return
     */
    Set<ContactsDTO> getAllContacts();

    /**
     * @param id = client id
     * @return Client by id
     */
    Contacts getContactsById(long id);

    /**
     * @param contacts  - contacts that should be added to DB
     * @return contacts
     */
    Contacts addContacts(Contacts contacts);

    /**
     * @param contact  - contact that should be update to DB
     * @return contacts
     */
    Contacts updateContacts(Contacts contact);

    /**
     * @param id - client id for remove
     * @return deleted contacts
     */
    Contacts deleteContacts(long id);
}
