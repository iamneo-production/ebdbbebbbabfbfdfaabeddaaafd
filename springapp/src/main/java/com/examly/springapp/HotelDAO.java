package com.examly.springapp;


import java.util.List;

public interface HotelDAO {
    void addHotel(Hotel hotel);
    List<Hotel> getAllHotels();
}
