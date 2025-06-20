package com.kiran.service;

import java.util.List;

import com.kiran.entity.Contact;

public interface ContactService {
	
	public Contact addContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact updateContact(Long id, Contact updatedContact);
	
	public void DeleteContact(Long id);

}
