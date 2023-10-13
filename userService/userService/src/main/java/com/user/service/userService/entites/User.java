package com.user.service.userService.entites;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="usersData")
public class User {

    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="NAME",length = 20,nullable = false)
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ABOUT")
    private String about;

@Transient
    private List<Rating> ratings= Arrays.asList();
}
