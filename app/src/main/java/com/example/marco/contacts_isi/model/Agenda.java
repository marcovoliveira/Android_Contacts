package com.example.marco.contacts_isi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 * Created by Marco on 05/12/2017.
 */

public class Agenda implements Serializable{
    private ArrayList<Contact> contacts;

    public Agenda () {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (containsPhone(contact.getPhone())) {
            throw new RuntimeException("Cannot add Contact to Agenda; phone number already exists.");
        }

        contacts.add(contact);
    }

    public boolean containsPhone(int phone) {
        for (Contact c : contacts) {
            if (c.getPhone() == phone) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Contact> searchContactByPhone(int phone) {
        ArrayList<Contact> res = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getPhone() == phone) {
                res.add(c);
            }
        }
        return res;
    }

    public ArrayList<Contact> searchContactByName(String name) {
        ArrayList<Contact> res = new ArrayList<>();
        for (Contact c : contacts) {
            if (Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(c.getName()).find()) {
                res.add(c);
            }
        }
        return res;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        String res = "";
        for (Contact c : contacts) {
            res += c + "\n";
        }
        return res;
    }
}


