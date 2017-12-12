package com.example.marco.contacts_isi.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private int phone;


    public Contact(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Name: " + name + "; Phone: " + phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        if (phone != contact.phone) return false;
        return name.equals(contact.name);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phone;
        return result;
    }
}


