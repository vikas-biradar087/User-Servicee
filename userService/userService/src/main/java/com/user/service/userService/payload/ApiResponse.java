package com.user.service.userService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Builder
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
