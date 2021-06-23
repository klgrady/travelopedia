package com.travelopedia.model;

// this was previously location code. I changed it to Airport to match the db. added new property Airport ID, Airport Code and Airport City

public enum Airport {
    SAN(1, "San Diego, CA", "Hartfield International"),
    PHX(2, "Phoenix, AZ", "Phoenix Sky Harbor International"),
    DEN(14, "Denver, CO", "Denver International"),
    IAD(3, "Washington, DC", "Washington Dulles International"),
    MIA(4, "Miami, FL", "Miami International"),
    SEA(5, "Seattle, WA", "Seattle Tacoma International"),
    SFO(6, "San Francisco, CA", "San Francisco International"),
    LGA(7, "New York City, NY", "La Guardia"),
    ORF(8, "Norfolk, VA", "Norfolk International"),
    CLE(9, "Cleveland,OH", "Cleveland Hopkins International"),
    LAX(10, "Los Angeles, CA", "Los Angeles International"),
    BUF(11, "Buffalo, NY", "Buffalo Niagara International"),
    EWR(12, "Newark, NJ", "Newark International"),
    MSP(13, "Minneapolis, MN", "Minneapolis St. Paul International");


    private int AirportID;
    private String AirportCode;
    private String AirportCity;


    Airport(int airportID, String airportCode, String airportCity) {
        this.AirportID = airportID;
        this.AirportCode = airportCode;
        this.AirportCity = airportCity;
    }

    public int getAirportID() {
        return AirportID;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public String getAirportCity() {
        return AirportCity;
    }
}