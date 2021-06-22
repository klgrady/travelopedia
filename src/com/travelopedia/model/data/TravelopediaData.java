package com.travelopedia.model.data;

import com.travelopedia.model.Flight;
import com.travelopedia.model.Traveler;
import com.travelopedia.model.Trip;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelopediaData {

    static Map<Long, Traveler> customerList = new HashMap<>(); // customer data
    static Map<Long, Flight> flightList = new HashMap<>();  // flights available
    static Map<Long, Trip> tripList = new HashMap<>();      // booked travel
    static final String path = "src/com/travelopedia/model/data/";

    public TravelopediaData() throws IOException {
        List<String> cList = new ArrayList<>();
        List<String> tList = new ArrayList<>();
        List<String> fList = new ArrayList<>();

        //open customer.csv and import to customerList
        cList = loadData(path + "customer.csv");
        loadCustomerData(cList);
        //open flights.csv and import to flightList
        fList = loadData(path + "flights.csv");
    }

    private static void loadCustomerData(List<String> cList) {
        for (String line : cList) {
            String[] tempList = line.split(",");
            Long id = Long.valueOf(tempList[0]);
            String fname = tempList[1];
            String lname = tempList[2];
            String email = "";
            String phone = tempList[3];
            String streetAddress = tempList[4];
            String city = tempList[5];
            String state = tempList[6];
            String zip = tempList[7];
            String ccNum = tempList[8];
            customerList.put(id, new Traveler(id, fname, lname, email, phone, streetAddress, city,
                    state, zip, ccNum, null));
        }

    }

    private static void loadFlightData(List<String> fList) {
        Long id = Long.valueOf(fList.get(0));
        String airline = fList.get(1);
        String departureCity = fList.get(2);
        String arrivalCity = fList.get(3);
        String departureTime = fList.get(4);
        String arrivalTime = fList.get(5);
        String seatCapacity = fList.get(6);
        String seatsAvailable = fList.get(7);
        String seatsBooked = fList.get(8);

        flightList.put(id, new Flight(id, airline, departureCity, arrivalCity, departureTime, arrivalTime, seatCapacity, seatsAvailable, seatsBooked));
    }

    private static List<String> loadData(String file) throws IOException {
        return Files.readAllLines(FileSystems.getDefault().getPath(file));
    }

    public static Map<Long, Traveler> getCustomerList() {
        return customerList;
    }

    public static Map<Long, Flight> getFlightList() {
        return flightList;
    }

    public static Map<Long, Trip> getTripList() {
        return tripList;
    }
}