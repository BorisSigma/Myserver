package com.example.MyServer.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String login;
    private String city;
    private double starsValue;
    private String username;
    private String password;
}