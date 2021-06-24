package com.travelopedia.model;

import java.time.LocalDateTime;
import java.util.*;

public class Flight {
    private List<Leg> legs = new ArrayList<>();

    public Flight() {
        //no-op
    }
    public Flight(Long id, String airline, String departureCity, String arrivalCity, String departureTime,
                  String arrivalTime, String seatCapacity, String seatsAvailable, String seatsBooked) {
        addLeg(id, LocalDateTime.parse(departureTime.trim()), Airport.valueOf(departureCity.trim()),
                LocalDateTime.parse(arrivalTime.trim()), Airport.valueOf(arrivalCity.trim()), Airline.valueOf(airline.trim()), 399.0,
                Integer.parseInt(seatCapacity.trim()), Integer.parseInt(seatsAvailable.trim()), Integer.parseInt(seatsBooked.trim()));
    }

    public void addLeg(Long id,
                       LocalDateTime departureDateTime,
                       Airport departureLocation,
                       LocalDateTime arrivalDateTime,
                       Airport arrivalLocation,
                       Airline carrier,
                       double price,
                       int seatCapacity,
                       int seatsAvailable,
                       int seatsBooked) {
        legs.add(new Leg(id, departureDateTime, departureLocation, arrivalDateTime, arrivalLocation, carrier, price, seatCapacity, seatsAvailable, seatsBooked));
    }

    // Creates a map itinerary containing String values for all elements, natural ordering on departure date/time of
    // each leg.
    public Map<LocalDateTime, List<String>> getItinerary() {
        Map<LocalDateTime, List<String>> itinerary = new TreeMap<>();
        for (Leg leg : legs) {
            List<String> legInfo = new ArrayList<>();
            legInfo.add(leg.getId().toString());
            legInfo.add(leg.getDepartureDateTime().toString());
            legInfo.add(leg.getDepartureLocationName());
            legInfo.add(leg.getArrivalDateTime().toString());
            legInfo.add(leg.getArrivalLocationName());
            legInfo.add(leg.getCarrierName());
            legInfo.add(Double.toString(leg.getPrice()));
            legInfo.add(Integer.toString(leg.getSeatsAvailable()));
            itinerary.put(leg.getDepartureDateTime(), legInfo);
        }
        return itinerary;
    }

    public String returnFlightInfo() {
        String departureDate = legs.get(0).getDepartureDateTime().toString();
        String departureLoc = legs.get(0).getDepartureLocationName();
        String departureLocGeo = legs.get(0).getDepartureLocationGeo();
        String arrivalDate = legs.get(0).getArrivalDateTime().toString();
        String arrivalLoc = legs.get(0).getArrivalLocationName();
        String arrivalLocGeo = legs.get(0).getArrivalLocationGeo();
        String price = Double.toString(legs.get(0).getPrice());
        String result = "Depart: " + departureDate + " " + departureLoc + " (" + departureLocGeo + "), Arrive: " +
                arrivalDate + " " + arrivalLoc + " (" + arrivalLocGeo + "), Price: " + price;
        return result;
    }

    private List<Leg> getLegs() {
        return legs;
    }

    public LocalDateTime getDepartureDate() {
        return legs.get(0).departureDateTime;
    }

    public Airport getDepartureLocation() {
        return legs.get(0).departureLocation;
    }

    //inner class
    class Leg {
        Long id;
        LocalDateTime departureDateTime;
        LocalDateTime arrivalDateTime;
        Airline carrier;
        Airport departureLocation;
        Airport arrivalLocation;
        double price;
        int seatCapacity;
        int seatsAvailable;
        int seatsBooked;

        public Leg(Long id,
                   LocalDateTime departureDateTime,
                   Airport departureLocation,
                   LocalDateTime arrivalDateTime,
                   Airport arrivalLocation,
                   Airline carrier,
                   double price,
                   int seatCapacity,
                   int seatsAvailable,
                   int seatsBooked) {
            this.id = id;
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

        private Airport getDepartureLocation() {
            return departureLocation;
        }

        private String getDepartureLocationGeo() {
            return departureLocation.getAirportCity();
        }

        private String getDepartureLocationName() {
            return departureLocation.getAirportCode();
        }

        private void setDepartureLocation(Airport departureLocation) {
            this.departureLocation = departureLocation;
        }

        private Airport getArrivalLocation() {
            return arrivalLocation;
        }
        private String getArrivalLocationGeo() {
            return arrivalLocation.getAirportCity();
        }

        private String getArrivalLocationName() {
            return arrivalLocation.getAirportCode();
        }

        private void setArrivalLocation(Airport arrivalLocation) {
            this.arrivalLocation = arrivalLocation;
        }

        private double getPrice() {
            return price;
        }

        private int getSeatCapacity() {
            return seatCapacity;
        }

        private int getSeatsAvailable() {
            return seatsAvailable;
        }

        private int getSeatsBooked() {
            return seatsBooked;
        }

        private boolean adjustBookingSeats() {
            if (isSeatAvailable()) {
                seatsAvailable--;
                seatsBooked++;
                return true;
            }
            return false;
        }

        private void setPrice(double price) {
            this.price = price;
        }


        public Long getId() {
            return id;
        }

    }

    public Long getId() {
        return getLegs().get(0).getId();
    }

    public boolean isSeatAvailable() {
        boolean result = true;
        for (Leg leg : getLegs()) {
            if (leg.getSeatsAvailable() == 0) {
                result = false;
            }
        }
        return result;
    }

    public void adjustSeatsForBooking() {
        getLegs().get(0).adjustBookingSeats();
    }

    public String dumpFlights() {
        String result = "";
        for (Leg leg : getLegs()) {
            result = leg.getId() + "," + leg.getCarrier() + "," + leg.getDepartureLocation() + "," + leg.getArrivalLocation() + ","
                    + leg.getDepartureDateTime().toString() + "," + "," + leg.getArrivalDateTime().toString() + "," +
                    leg.getSeatCapacity() + "," + leg.getSeatsAvailable() + leg.getSeatsBooked() + "\n";
        }
        return result;
    }

    public String toString() {
        String result = "";
        for (Leg leg : getLegs()) {
            result += leg.getId() + "," + leg.getCarrier() + "," + leg.getDepartureLocationName() +
                    "," + leg.getArrivalLocationName() + "," +leg.getDepartureDateTime().toString() + "," +
                    leg.getArrivalDateTime().toString() + ", " +
                    leg.getSeatCapacity() + "," + leg.getSeatsBooked() + "," + leg.getSeatsAvailable();
        }
        return result;
    }

}