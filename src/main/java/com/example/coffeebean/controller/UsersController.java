package com.example.coffeebean.controller;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    @PostMapping("/signUp")
    public ResponseEntity<UsersSignUpResponseDto> signUp(@RequestBody UsersSignUpRequestDto usersSignUpRequestDto){
        UsersSignUpResponseDto dto = usersService.signUp(usersSignUpRequestDto);
        return ResponseEntity.ok().body(dto);
    }
}
