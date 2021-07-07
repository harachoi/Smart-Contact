package repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.developer.smartcontact.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {

    void deletecontactById(Long id);

    Optional<Contact> findContactById(Long id);

}
