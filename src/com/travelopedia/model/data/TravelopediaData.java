package com.travelopedia.model.data;

import com.travelopedia.model.Flight;
import com.travelopedia.model.Traveler;
import com.travelopedia.model.Trip;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

/**
 * The Data
 * Gets data from a CSV file and holds maps of customers, flights, and trips.
 * Writes data to the CSV file. Should be invoked when a purchase is completed.
 */
public class TravelopediaData {

    static Map<Long, Traveler> customerList = new HashMap<>(); // customer data
    static Map<Long, Flight> flightList = new HashMap<>();  // flights available
    static Map<Long, Trip> tripList = new HashMap<>();      // booked travel
    static final String path = "config/";
    static final String customerFile = "customer.csv";
    static final String flightFile = "flights.csv";
    static final String tripFile = "trips.csv";

    public TravelopediaData() {
        List<String> cList;
        List<String> tList = new ArrayList<>();
        List<String> fList;

        try {
            //open customer.csv and import to customerList
            cList = loadData(path + customerFile);
            loadCustomerData(cList);
            //open flights.csv and import to flightList
            fList = loadData(path + flightFile);
            loadFlightData(fList);
        } catch (IOException e) {
            System.out.println(e + " Unable to open files");
        }
    }

    public void record() {
        try {
            writeCustomerData();
            writeTripData();
            writeFlightData();
        } catch (IOException e) {
            System.out.println("Could not write data to files");
        }
    }

    private void loadCustomerData(List<String> cList) {
        for (String line : cList) {
            String[] tempList = line.split(",");
            Long id = Long.valueOf(tempList[0]);
            String fname = tempList[1];
            String lname = tempList[2];
            String email = tempList[3];
            String phone = tempList[4];
            String streetAddress = tempList[5];
            String city = tempList[6];
            String state = tempList[7];
            String zip = tempList[8];
            String ccNum = tempList[9];
            customerList.put(id, new Traveler(id, fname, lname, email, phone, streetAddress, city,
                    state, zip, ccNum, null));
        }

    }

    private void loadFlightData(List<String> fList) {
        for (String line : fList) {
            String[] tempList = line.split(",");
            Long id = Long.valueOf(tempList[0]);
            String airline = tempList[1];
            String departureCity = tempList[2];
            String arrivalCity = tempList[3];
            String departureTime = tempList[4];
            String arrivalTime = tempList[5];
            String seatCapacity = tempList[6];
            String seatsAvailable = tempList[7];
            String seatsBooked = tempList[8];
            flightList.put(id, new Flight(id, airline, departureCity, arrivalCity, departureTime, arrivalTime, seatCapacity, seatsAvailable, seatsBooked));
        }
    }

    private List<String> loadData(String file) throws IOException {
        return Files.readAllLines(FileSystems.getDefault().getPath(file));
    }

    static void writeCustomerData() throws IOException {
        Files.writeString(FileSystems.getDefault().getPath(path, customerFile), "");  // clear the file
        for (Map.Entry<Long,Traveler> customer : customerList.entrySet()) {
            Files.writeString(FileSystems.getDefault().getPath(path, customerFile), customer.getValue().toString(), StandardOpenOption.APPEND);
        }
    }

    private static void writeTripData() throws IOException {
        Files.writeString(FileSystems.getDefault().getPath(path, tripFile), "");  // clear the file
        for (Map.Entry<Long,Trip> trip : tripList.entrySet()) {
            Files.writeString(FileSystems.getDefault().getPath(path, tripFile), trip.getValue().toString() + "\n", StandardOpenOption.APPEND);
        }
    }

    private static void writeFlightData() throws IOException {
        Files.writeString(FileSystems.getDefault().getPath(path, flightFile), "");  // clear the file
        for (Map.Entry<Long,Flight> flight : flightList.entrySet()) {
            Files.writeString(FileSystems.getDefault().getPath(path, flightFile), flight.getValue().toString() + "\n", StandardOpenOption.APPEND);
        }
    }

    public Map<Long, Traveler> getCustomerList() {
        return customerList;
    }

    public Map<Long, Flight> getFlightList() {
        return flightList;
    }

    public Map<Long, Trip> getTripList() {
        return tripList;
    }

    private void addToTripList(Long key, Trip trip) {
        List<Flight> flights = new ArrayList<>();
        for (Flight fl : trip.getFlights()) {
            flights.add(fl);
        }
        if (tripList.containsKey(key)) {
            for (Flight fl : tripList.get(key).getFlights()) {
                flights.add(fl);
            }
        }
        tripList.put(key, trip);
    }

    public Long recordNewTrip(Long flightsInTrip, Long customerId) {
        // create new TripID that doesn't already exist
        Long tripId = 0L;
        while (tripId > 0L && !tripList.containsKey(tripId)) {
            tripId = Math.abs(new Random().nextLong());
        }

        // get all related flights from List<Long> of flightIDs
        List<Flight> flightsArrayList = new ArrayList<>();
        Flight getFlight = flightList.get(flightsInTrip);
        flightsArrayList.add(getFlight);
        getFlight.adjustSeatsForBooking();  // will adjust seatsBooked and seatsAvailable for each leg

        // create new trip from the current trip flight list
        Trip trip = new Trip(tripId, customerId, flightsArrayList);
        addToTripList(tripId, trip);

        return tripId;
    }

    public void createNewCustomer(Long id, String fname, String lname, String email, String ccNum) {
        Traveler customer = new Traveler(id, fname, lname, email, "", "", "", "", "", ccNum, null);
        customerList.put(id, customer);
    }

}