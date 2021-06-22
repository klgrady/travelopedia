package com.travelopedia.model;

import java.time.LocalDateTime;
import java.util.*;

public class Flight {
    private List<Leg> legs = new ArrayList<>();

    public Flight() {
        //no-op
    }
    public Flight(Long id, String airline, String departureCity, String arrivalCity, String departureTime, String arrivalTime, String seatCapacity, String seatsAvailable, String seatsBooked) {
        addLeg(LocalDateTime.parse(departureTime), LocationCode.valueOf(departureCity), LocalDateTime.parse(arrivalTime), LocationCode.valueOf(arrivalCity), Airline.valueOf(airline), 399.0,
                Integer.parseInt(seatCapacity), Integer.parseInt(seatsAvailable), Integer.parseInt(seatsBooked));
    }

    public void addLeg(LocalDateTime departureDateTime,
                       LocationCode departureLocation,
                       LocalDateTime arrivalDateTime,
                       LocationCode arrivalLocation,
                       Airline carrier,
                       double price,
                       int seatCapacity,
                       int seatsAvailable,
                       int seatsBooked) {
        legs.add(new Leg(departureDateTime, departureLocation, arrivalDateTime, arrivalLocation, carrier, price, seatCapacity, seatsAvailable, seatsBooked));
    }
    public List<Leg> getLegs() {
        return legs;
    }

    // Creates a map itinerary containing String values for all elements, natural ordering on departure date/time of
    // each leg.
    public Map<LocalDateTime, List<String>> getItinerary() {
        Map<LocalDateTime, List<String>> itinerary = new TreeMap<>();
        for (Leg leg : legs) {
            List<String> legInfo = new ArrayList<>();
            legInfo.add(leg.getDepartureDateTime().toString());
            legInfo.add(leg.getDepartureLocationName());
            legInfo.add(leg.getArrivalDateTime().toString());
            legInfo.add(leg.getArrivalLocationName());
            legInfo.add(leg.getCarrierName());
            legInfo.add(Double.toString(leg.getPrice()));
            itinerary.put(leg.getDepartureDateTime(), legInfo);
        }
        return itinerary;
    }

    //inner class
    class Leg {
        LocalDateTime departureDateTime;
        LocalDateTime arrivalDateTime;
        Airline carrier;
        LocationCode departureLocation;
        LocationCode arrivalLocation;
        double price;
        int seatCapacity;
        int seatsAvailable;
        int seatsBooked;

        public Leg(LocalDateTime departureDateTime,
                   LocationCode departureLocation,
                   LocalDateTime arrivalDateTime,
                   LocationCode arrivalLocation,
                   Airline carrier,
                   double price,
                   int seatCapacity,
                   int seatsAvailable,
                   int seatsBooked) {
            this.departureDateTime = departureDateTime;
            this.arrivalDateTime = arrivalDateTime;
            this.carrier = carrier;
            this.departureLocation = departureLocation;
            this.arrivalLocation = arrivalLocation;
            this.price = price;
            this.seatCapacity = seatCapacity;
            this.seatsAvailable = seatsAvailable;
            this.seatsBooked = seatsBooked;
        }

        private LocalDateTime getDepartureDateTime() {
            return departureDateTime;
        }

        private void setDepartureDateTime(LocalDateTime departureDateTime) {
            this.departureDateTime = departureDateTime;
        }

        private Airline getCarrier() {
            return carrier;
        }

        private String getCarrierName() {
            return carrier.getName();
        }

        private void setCarrier(Airline carrier) {
            this.carrier = carrier;
        }

        private LocalDateTime getArrivalDateTime() {
            return arrivalDateTime;
        }

        private void setArrivalDateTime(LocalDateTime arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
        }

        private LocationCode getDepartureLocation() {
            return departureLocation;
        }

        private String getDepartureLocationGeo() {
            return departureLocation.getLocation();
        }

        private String getDepartureLocationName() {
            return departureLocation.getName();
        }

        private void setDepartureLocation(LocationCode departureLocation) {
            this.departureLocation = departureLocation;
        }

        private LocationCode getArrivalLocation() {
            return arrivalLocation;
        }
        private String getArrivalLocationGeo() {
            return arrivalLocation.getLocation();
        }

        private String getArrivalLocationName() {
            return arrivalLocation.getName();
        }

        private void setArrivalLocation(LocationCode arrivalLocation) {
            this.arrivalLocation = arrivalLocation;
        }

        private double getPrice() {
            return price;
        }

        public int getSeatCapacity() {
            return seatCapacity;
        }

        public int getSeatsAvailable() {
            return seatsAvailable;
        }

        public int getSeatsBooked() {
            return seatsBooked;
        }

        private void setPrice(double price) {
            this.price = price;
        }
    }
}