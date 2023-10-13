package com.rating.service.service;

import com.rating.service.entites.Rating;

import java.util.List;

public interface RatingService {


    public  Rating create(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //get all by userid
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

}
