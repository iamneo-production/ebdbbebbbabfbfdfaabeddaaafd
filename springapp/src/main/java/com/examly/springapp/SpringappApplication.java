package com.examly.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);

        HotelDAO hotelDAO = new HotelDAOImpl();

        // Create a list of hotels to add
        List<Hotel> hotelsToAdd = new ArrayList<>();
        hotelsToAdd.add(new Hotel(1, "Hotel A", "Location A", 4.0f, true, true, false));
        hotelsToAdd.add(new Hotel(2, "Hotel B", "Location B", 3.5f, true, false, true));
        hotelsToAdd.add(new Hotel(3, "Hotel C", "Location C", 3.8f, false, true, false));

        // Add each hotel to the database
        for (Hotel hotel : hotelsToAdd) {
            hotelDAO.addHotel(hotel);
        }

       // Retrieve and display all hotel records
        List<Hotel> hotels = hotelDAO.getAllHotels();
        for (Hotel hotel : hotels) {
            System.out.println("Hotel ID: " + hotel.getId());
            System.out.println("Name: " + hotel.getHotelName());
            System.out.println("Location: " + hotel.getLocation());
            System.out.println("Rating: " + hotel.getRating());
            System.out.println("Pool: " + hotel.isPool());
            System.out.println("Gym: " + hotel.isGym());
            System.out.println("Spa: " + hotel.isSpa());
            System.out.println();
        }
    }
}
