package com.example.sqliteandroidd05.model;

public class Contact {
    public int id;
    public String name;
    public String phone;

    public Contact() {
    }

    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
