package com.example.coffeebean.controller;

import com.example.coffeebean.dto.UsersSignInRequestDto;
import com.example.coffeebean.dto.UsersSignInResponseDto;
import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    //회원가입
    @PostMapping("/signUp")
    public ResponseEntity<UsersSignUpResponseDto> signUp(@RequestBody UsersSignUpRequestDto usersSignUpRequestDto){
        UsersSignUpResponseDto dto = usersService.signUp(usersSignUpRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    //로그인
    @PostMapping("/signIn")
    public ResponseEntity<UsersSignInResponseDto> signIn(@RequestBody UsersSignInRequestDto usersSignInRequestDto){
        UsersSignInResponseDto dto = usersService.signIn(usersSignInRequestDto);
        return ResponseEntity.ok().body(dto);
    }

    //로그아웃
//    @GetMapping("/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "logoutSuccess";
//    }
    //이번주 커피 추가
    @PostMapping("/addThisWeekCoffee")
    public ResponseEntity<AddThisWeekCoffeeResponse> addThisWeekCoffee(@RequestBody AddThisWeek){

    }

}
