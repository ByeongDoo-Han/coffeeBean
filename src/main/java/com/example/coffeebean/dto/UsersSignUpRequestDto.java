package com.example.coffeebean.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsersSignUpRequestDto {
    public String username;
    public String password;
}
