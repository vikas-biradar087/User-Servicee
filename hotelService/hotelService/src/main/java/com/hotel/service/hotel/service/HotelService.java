package com.hotel.service.hotel.service;

import com.hotel.service.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String hotelId);

}
