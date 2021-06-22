package com.travelopedia.model;

public enum Airline {
    AA(1L, "Average Airlines", "AA"),
    UA(2L, "Ultimate Airlines", "UA"),
    SA(3L, "Serviceable Airlines", "SA"),
    BA(4L, "Best Airlines", "BA"),
    CA(5L, "CheapSeats Airlines", "CA");

    private long id;
    private String name;
    private String code;

    Airline(Long id, String name, String code) {
        this.id = id;
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