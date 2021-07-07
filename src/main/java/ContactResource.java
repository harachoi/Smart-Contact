import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.developer.smartcontact.Contact;

import java.util.List;
import service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactResource {
    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all") // get request
    public ResponseEntity<List<Contact>> getAllContact() {
        List<Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id) {
        Contact contact = contactService.findContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact newContact = contactService.addContact(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/add")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        Contact updateContact = contactService.updateContact(contact);
        return new ResponseEntity<>(updateContact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
