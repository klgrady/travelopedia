package com.travelopedia.controller;

import com.travelopedia.model.Traveler;
import com.travelopedia.model.data.TravelopediaData;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TravelerAccess {

    public static Long createCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your first name: ");
        System.out.print("> ");
        String fname = sc.next();
        System.out.println("Your last name: ");
        System.out.print("> ");
        String lname = sc.next();
        System.out.println("Your email address: ");
        System.out.print("> ");
        String email = sc.next();
        System.out.println("Your credit card number (we pinky swear it's secure!): ");
        System.out.print("> ");
        String ccNum = sc.next();

        TravelopediaData db = new TravelopediaData();
        Long id = new Random().nextLong();
        db.createNewCustomer(id, fname, lname, email, ccNum);
        return id;
    }

    public static Long getCustIdByEmail() {
        TravelopediaData database = new TravelopediaData();
        Long custId = 0L;
        Scanner sc = new Scanner(System.in);
        System.out.println("What email address did you use to register? ");
        System.out.print("> ");
        String email = sc.next();
        Map<Long, Traveler> customers = database.getCustomerList();
        for (Map.Entry<Long, Traveler> customer : customers.entrySet()) {
            if (customer.getValue().getEmail().equals(email)) {
                custId = customer.getKey();
            }
        }
        return custId;
    }
}