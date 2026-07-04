package com.amolD;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private ConcurrentHashMap<String, Contact> map = new ConcurrentHashMap<>();

    public void addContact(String name, String lastName, String phone) {
        Contact contact = new Contact(name, lastName, phone);
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();

        if (map.containsKey(phone)) {
            throw new RuntimeException("Contact with this phone number already exists.");
        }
        map.put(phone, contact);
        System.out.println("Contact added successfully.");
    }

    public Contact getContact(String phone) {
        return map.get(phone);
    }

    public Collection<Contact> getAllContacts() {
        return map.values();
    }

}