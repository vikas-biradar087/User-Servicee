package com.rating.service.service.impl;

import com.rating.service.entites.Rating;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public Rating create(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {

        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {

        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {

        return ratingRepo.findByHotelId(hotelId);
    }
}
