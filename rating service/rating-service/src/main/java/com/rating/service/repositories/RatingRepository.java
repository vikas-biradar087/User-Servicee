package com.rating.service.repositories;

import com.rating.service.entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {


    //custom finds methods

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);

}
