package com.user.service.userService.services;

import com.user.service.userService.entites.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    //get All user
    List<User> getAllUser();

    //get Single user

    User getUser(String userId);
}
