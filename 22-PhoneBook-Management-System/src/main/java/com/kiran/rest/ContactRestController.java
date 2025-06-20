package com.kiran.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.entity.Contact;
import com.kiran.service.ContactServiceImpl;

@RestController
public class ContactRestController {
	@Autowired
	private ContactServiceImpl service;

	@PostMapping("/contact")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
		Contact con = service.addContact(contact);
		return new ResponseEntity<Contact>(con, HttpStatus.CREATED);
	}

	@GetMapping("/contact")
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = service.getAllContacts();
		return allContacts;
	}

	@PutMapping("/contact/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
		Contact updatedContact = service.updateContact(id, contact);
		return new ResponseEntity<Contact>(updatedContact, HttpStatus.CREATED);
	}

	@DeleteMapping("/contact/{id}")
	public String deleteContact(@PathVariable Long id) {
		service.DeleteContact(id);
		return "Contact Deleted Successfully";
	}

}
