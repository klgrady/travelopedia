package com.travelopedia.model;

public enum Airline {
    AVERAGE("Average Airlines", "AA"),
    ULTIMATE("Ultimate Airlines", "UA"),
    SERVICEABLE("Serviceable Airlines", "SA"),
    BEST("Best Airlines", "BA"),
    CHEAP("CheapSeats Airlines", "CA");

    private String name;
    private String code;

    Airline(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}