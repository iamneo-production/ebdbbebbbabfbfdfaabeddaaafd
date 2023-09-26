package com.examly.springapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SpringappApplicationTests {

    private HotelDAO hotelDAO;

    @Before
    public void setUp() {
        // Initialize the HotelDAO (you can also use dependency injection to inject it)
        hotelDAO = new HotelDAOImpl();
    }

    @Test
    public void testAddHotel() {
        // Create a sample hotel to add
        Hotel sampleHotel = new Hotel(1, "Sample Hotel", "Sample Location", 4.0f, true, true, false);

        // Add the hotel to the database
        hotelDAO.addHotel(sampleHotel);

        // Retrieve the added hotel from the database
        List<Hotel> hotels = hotelDAO.getAllHotels();

        // Check if the hotel is in the list
        boolean hotelFound = false;
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(sampleHotel.getHotelName())) {
                hotelFound = true;
                break;
            }
        }

        assertTrue(hotelFound);
    }

    @Test
    public void testGetAllHotels() {
        // Assuming there are some hotels already in the database
        List<Hotel> hotels = hotelDAO.getAllHotels();

        // Check if the retrieved list is not null and not empty
        assertNotNull(hotels);
        assertFalse(hotels.isEmpty());
    }
}
