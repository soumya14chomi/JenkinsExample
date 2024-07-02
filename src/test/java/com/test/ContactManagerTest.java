package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.demo.contactManager.ContactManager;

public class ContactManagerTest {

	@Test
	public void shouldCreateContact() {
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("Soumya", "Namani", "0898989898");

		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());

		Assertions.assertEquals(contactManager.getAllContacts().size(), 1);

//		System.out.println(contactManager.getAllContacts().size());

		Assertions.assertTrue(contactManager
				.getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Soumya")
						&& contact.getLastName().equals("Namani") && contact.getPhoneNumber().equals("0898989898"))
				.findAny().isPresent());

	}

	@Test
	@DisplayName("Should not create contact if first name is null")
	public void shouldThrowrunTimeExceptionIfFirstNameIsNull() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact(null, "Namani", "0889898989");

		});

	}

}
