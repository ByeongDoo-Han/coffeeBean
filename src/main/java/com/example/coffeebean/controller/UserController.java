package com.example.coffeebean.controller;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UsersSignUpRequestDto usersSignUpRequestDto){
        ResponseEntity<Users> response = new ResponseEntity<>(HttpStatus.OK);
        respons
        return response;
    }
}
