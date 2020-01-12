package com.example.green;

import android.location.Location;

public class Store {
    private String name;
    private String location;
    private String category;
    private String contacts;
    private Location latlang;

    public Store(String name, String location, String category, String contacts) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.contacts = contacts;
        this.latlang = new Location(location);
    }
    public Store(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public int getImage() {
        return 0;
    }
}
