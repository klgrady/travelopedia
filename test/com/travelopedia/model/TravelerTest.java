package com.travelopedia.model;

import junit.framework.TestCase;
import org.junit.Test;

public class TravelerTest extends TestCase {

    @Test
    public void testTestToString() {
        Traveler cust = new Traveler();
        cust.setFname("Donna");
        cust.setLname("Smith");
        cust.setCcNum("239857023985");
        System.out.println(cust.toString());
    }
}