package com.example.coffeebean.dto;

import lombok.Builder;

@Builder
public class UsersSignUpRequestDto {
    private String userName;
    private String password;
}
