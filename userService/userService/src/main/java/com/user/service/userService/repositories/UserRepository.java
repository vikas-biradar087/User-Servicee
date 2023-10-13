package com.user.service.userService.repositories;

import com.user.service.userService.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


    //if you want impl any custom or query
}
