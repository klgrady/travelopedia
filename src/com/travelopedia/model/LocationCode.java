package com.travelopedia.model;

enum LocationCode {
    SAN("San Diego, CA", "Hartfield International"),
    PHX("Phoenix, AZ", "Phoenix Sky Harbor International"),
    DEN("Denver, CO", "Denver International"),
    IAD("Washington, DC", "Washington Dulles International"),
    MIA("Miami, FL", "Miami International"),
    SEA("Seattle, WA", "Seattle Tacoma International"),
    SFO("San Francisco, CA", "San Francisco International"),
    LGA("New York City, NY", "La Guardia"),
    ORF("Norfolk, VA", "Norfolk International"),
    CLE("Cleveland,OH", "Cleveland Hopkins International"),
    LAX("Los Angeles, CA", "Los Angeles International"),
    BUF("Buffalo, NY", "Buffalo Niagara International"),
    EWR("Newark, NJ", "Newark International"),
    MSP("Minneapolis, MN", "Minneapolis St. Paul International");

    private String location;
    private String name;
    LocationCode(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}