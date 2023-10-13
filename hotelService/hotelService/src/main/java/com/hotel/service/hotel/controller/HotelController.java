package com.hotel.service.hotel.controller;

import com.hotel.service.hotel.entites.Hotel;
import com.hotel.service.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel hotel1 = this.hotelService.create(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id){
        Hotel hotel = hotelService.get(id);
        return ResponseEntity.ok(hotel);
    }


    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotelall = hotelService.getAll();
        return ResponseEntity.ok(hotelall);

    }

}
