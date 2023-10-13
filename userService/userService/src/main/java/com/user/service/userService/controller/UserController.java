package com.user.service.userService.controller;

import com.user.service.userService.entites.User;
import com.user.service.userService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    @GetMapping("/{userId}")
   // @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUserId(@PathVariable String userId){
        logger.info("get single user Handler: UserController");
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }


    //creating fall back method for circuitbreaker
//    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
//
//        logger.info("Fallback is executed because service is down :",ex.getMessage());
//        User user = User.builder()
//                .email("vv@gmail.com")
//                .name("Arjun")
//                .about("This user is created dummy because some services down")
//                .userId("254741")
//                .build();
//        return new ResponseEntity<>(user,HttpStatus.OK);
//
//    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);

    }
}
