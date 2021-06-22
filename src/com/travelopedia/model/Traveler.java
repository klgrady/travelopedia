package com.travelopedia.model;

import java.util.*;

public class Traveler {
    private long id = 0;
    private String fname = "";
    private String lname = "";
    private String password = "";
    private String email = "";
    private String phone = "";
    private String streetAddress = "";
    private String city = "";
    private String state = "";
    private String zip = "";
    private String ccNum = "";
    private List<Trip> trips;

    public Traveler() {
        trips = new ArrayList<>();
    }

    public Traveler(long id, String fname, String lname, String email, String phone, String streetAddress, String city,
                    String state, String zip, String ccNum, List<Trip> tripList) {
        this();
        setId(id);
        setFname(fname);
        setLname(lname);
        setEmail(email);
        setPhone(phone);
        setStreetAddress(streetAddress);
        setCity(city);
        setState(state);
        setZip(zip);
        setCcNum(ccNum);
        trips = tripList;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
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