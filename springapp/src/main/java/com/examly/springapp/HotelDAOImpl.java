package com.examly.springapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    @Override
   public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection(); // Use your JDBCUtils class to get the connection
            preparedStatement = conn.prepareStatement("SELECT * FROM hotels");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setHotelName(resultSet.getString("hotelname"));
                hotel.setGym(resultSet.getBoolean("gym"));
                hotel.setLocation(resultSet.getString("location"));
                hotel.setRating(resultSet.getFloat("rating"));
                hotel.setPool(resultSet.getBoolean("pool"));
                hotel.setSpa(resultSet.getBoolean("spa"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResultSet(resultSet);
            JDBCUtils.closeStatement(preparedStatement);
            JDBCUtils.closeConnection(conn);
        }

        return hotels;
    }

    @Override
    public void addHotel(Hotel hotel) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = JDBCUtils.getConnection(); // Use your JDBCUtils class to get the connection
            preparedStatement = conn.prepareStatement(
                    "INSERT INTO hotels (id,hotelname, location, rating, pool, gym, spa) VALUES (?,?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1,hotel.getId());
            preparedStatement.setString(2, hotel.getHotelName());
            preparedStatement.setString(3, hotel.getLocation());
            preparedStatement.setFloat(4, hotel.getRating());
            preparedStatement.setBoolean(5, hotel.isPool());
            preparedStatement.setBoolean(6, hotel.isGym());
            preparedStatement.setBoolean(7, hotel.isSpa());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeStatement(preparedStatement);
            JDBCUtils.closeConnection(conn);
        }
    }
}
