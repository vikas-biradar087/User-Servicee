package com.user.service.userService.services.impl;

import com.user.service.userService.entites.Hotel;
import com.user.service.userService.entites.Rating;
import com.user.service.userService.entites.User;
import com.user.service.userService.exception.ResourceNotFoundException;
//import com.user.service.userService.external.service.HotelService;
import com.user.service.userService.repositories.UserRepository;
import com.user.service.userService.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

  //  @Autowired
    //private HotelService hotelService;

     Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        //generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {

        //implement Rating service call using rest template

        return userRepo.findAll();

    }

    @Override
    public User getUser(String userId) {

        //get user from database with the help of user repository
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! :" + userId));

        //http://localhost:9090/ratings/1b2b24e1-a2ee-4e83-8793-90dd3730e3df

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();



        List<Rating> rtg = ratings.stream().map(rating -> {

            //api call to hotel service to get the hotel
            //http://localhost:8888/hotels/45bb0de6-0418-4fed-9855-61dc3b799dc6
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = forEntity.getBody();//

           // Hotel hotel=hotelService.getHotel(rating.getHotelId());

           logger.info("response status code: {} ",forEntity.getStatusCode());

            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(rtg);
        return user;
    }
}
