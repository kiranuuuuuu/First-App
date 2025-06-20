package com.kiran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kiran.entity.Contact;
import com.kiran.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public Contact addContact(Contact contact) {
		repo.save(contact);
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = repo.findAll();
		return contacts;
	}

	@Override
	public Contact updateContact(Long id, Contact updatedContact) {
	    Optional<Contact> byId = repo.findById(id);
	    
	    if (byId.isPresent()) {
	        Contact existingContact = byId.get(); // Get the existing record
	        
	        // Update only the fields
	        existingContact.setName(updatedContact.getName());
	        existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
	        existingContact.setEmail(updatedContact.getEmail()); 
	        
	        // Save the updated contact
	        return repo.save(existingContact);
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found");
	    }
	}

	@Override
	public void DeleteContact(Long id) {
		repo.deleteById(id);
	}

}
