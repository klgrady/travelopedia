package com.travelopedia.model;

import java.util.*;

class Traveler {
    private long id = 0;
    private String fname = "";
    private String lname = "";
    private String password = "";
    private String email = "";
    private String phone = "";
    private List<Trip> trips;

    public Traveler() {
        trips = new ArrayList<>();
    }

    public Traveler(long id, String fname, String lname, String email, List<Trip> tripList) {
        this();
        setId(id);
        setFname(fname);
        setLname(lname);
        setEmail(email);
        trips = tripList;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Trip> getTrips() {
        return this.trips;
    }
}