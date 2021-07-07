package service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.developer.smartcontact.Contact;
import exceptions.UserNotFoundException;
import repo.ContactRepo;

@Service
public class ContactService {
    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact addContact(Contact contact) {
        contact.setContactCode(UUID.randomUUID().toString());
        return contactRepo.save(contact);
    }

    public List<Contact> findAllContacts() {
        return contactRepo.findAll();
    }

    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Contact findContactById(Long id) {
        return contactRepo.findContactById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteContact(Long id) {
        contactRepo.deletecontactById(id);
    }
}
