package com.example.coffeebean.service;

import com.example.coffeebean.dto.UsersSignInRequestDto;
import com.example.coffeebean.dto.UsersSignInResponseDto;
import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.entity.Users;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;


public interface UsersService {

    UsersSignUpResponseDto signUp(UsersSignUpRequestDto usersSignUpRequestDto);

    UsersSignInResponseDto signIn(HttpServletRequest request, UsersSignInRequestDto usersSignInRequestDto) throws Exception;

    Optional<Users> findOne(Long userId);
}
