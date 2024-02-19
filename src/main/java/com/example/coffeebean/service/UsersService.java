package com.example.coffeebean.service;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import org.springframework.http.ResponseEntity;


public interface UsersService {
    ResponseEntity<Users> signUp(UsersSignUpRequestDto usersSignUpRequestDto);
}
