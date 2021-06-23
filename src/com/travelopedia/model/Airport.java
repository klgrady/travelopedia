package com.travelopedia.model;

// this was previously location code. I changed it to Airport to match the db. added new property Airport ID, Airport Code and Airport City

public enum Airport {
    SAN(1, "SAN", "San Diego, CA"),
    PHX(2, "PHX", "Phoenix, AZ"),
    DEN(14, "DEN", "Denver, CO"),
    IAD(3, "IAD", "Washington, DC"),
    MIA(4, "MIA", "Miami, FL"),
    SEA(5, "SEA", "Seattle, WA"),
    SFO(6, "SFO", "San Francisco, CA"),
    LGA(7, "LGA", "New York City, NY"),
    ORF(8, "ORF", "Norfolk, VA"),
    CLE(9, "CLE", "Cleveland,OH"),
    LAX(10, "LAX", "Los Angeles, CA"),
    BUF(11, "BUF", "Buffalo, NY"),
    EWR(12, "EWR", "Newark, NJ"),
    MSP(13, "MSP", "Minneapolis, MN");


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