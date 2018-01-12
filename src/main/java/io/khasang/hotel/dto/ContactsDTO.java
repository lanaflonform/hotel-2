package io.khasang.hotel.dto;

import io.khasang.hotel.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ContactsDTO {
    private long id;
    private Set<PhoneDTO> phoneSet = new HashSet<>();
    private ArrayList<Address>  addressList = new ArrayList<>();
    private Set<MailDTO> mailSet = new HashSet<>();
    private Set<LinkDTO> linkSet = new HashSet<>();

    public Set<ContactsDTO> getContactsDTO(Set<Contacts> contactsSet) {
        Set<ContactsDTO> contactsDTOSet = new HashSet<>();

        for (Contacts contacts : contactsSet) {
            Set<PhoneDTO> phoneDTOS = new HashSet<>();
            List<Address> addressDTOS = new ArrayList<>();
            Set<MailDTO> mailDTOS = new HashSet<>();
            Set<LinkDTO> linkDTOS = new HashSet<>();

            ContactsDTO contactsDTO = new ContactsDTO();
            contactsDTO.setId(contactsDTO.getId());
            for (Phone phone : contacts.getPhoneSet()) {
                PhoneDTO phoneDTO = new PhoneDTO();
                phoneDTO.setId(phone.getId());
                phoneDTO.setNumber(phone.getNumber());
                phoneDTOS.add(phoneDTO);
            }
            for (Address address : contacts.getAddressList()) {
                Address addressDTO = new Address();
                addressDTO.setId(address.getId());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setNumberStreet(address.getNumberStreet());
                addressDTO.setNumberHouse(address.getNumberHouse());

                addressDTOS.add(addressDTO);
            }
            for (Mail mail : contacts.getMailSet()) {
                MailDTO mailDTO = new MailDTO();
                mailDTO.setId(mail.getId());
                mailDTO.setMail(mail.getMail());
                mailDTOS.add(mailDTO);
            }
            for (Link link : contacts.getLinkSet()) {
                LinkDTO linkDTO = new LinkDTO();
                linkDTO.setId(link.getId());
                linkDTO.setUrl(link.getUrl());
                linkDTOS.add(linkDTO);
            }
            contactsDTO.setPhoneSet(phoneDTOS);
            contactsDTO.setAddressList(addressDTOS);
            contactsDTO.setMailSet(mailDTOS);
            contactsDTO.setLinkSet(linkDTOS);
            contactsDTOSet.add(contactsDTO);
        }
        return contactsDTOSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<PhoneDTO> getPhoneSet() {
        return phoneSet;
    }

    public void setPhoneSet(Set<PhoneDTO> phoneSet) {
        this.phoneSet = phoneSet;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = (ArrayList<Address>) addressList;
    }

    public Set<MailDTO> getMailSet() {
        return mailSet;
    }

    public void setMailSet(Set<MailDTO> mailSet) {
        this.mailSet = mailSet;
    }

    public Set<LinkDTO> getLinkSet() {
        return linkSet;
    }

    public void setLinkSet(Set<LinkDTO> linkSet) {
        this.linkSet = linkSet;
    }
}
