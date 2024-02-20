package com.example.coffeebean.service;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.entity.Users;

import java.util.Optional;


public interface UsersService {

    UsersSignUpResponseDto signUp(UsersSignUpRequestDto usersSignUpRequestDto);

    Optional<Users> findOne(Long userId);
}
