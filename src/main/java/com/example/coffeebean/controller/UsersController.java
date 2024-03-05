package com.example.coffeebean.controller;

import com.example.coffeebean.dto.*;
import com.example.coffeebean.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @PostMapping("/user/signIn")
    public ResponseEntity<UsersSignInResponseDto> signIn(
            @RequestBody UsersSignInRequestDto usersSignInRequestDto,
            HttpServletRequest request,
            RedirectAttributes attributes){
        HttpSession session = request.getSession();
        UsersSignInResponseDto dto = usersService.signIn(usersSignInRequestDto);
        if(dto == null){
            session.setAttribute("user", null);
            attributes.addFlashAttribute("msg", false);
        }else{
            session.setAttribute("user", dto);
        }
        return ResponseEntity.ok().body(dto);
    }

    //이번주 커피 추가
    @PostMapping("/user/coffee/thisweek")
    public ResponseEntity<ThisWeekAddResponseDto> addThisWeekCoffee(@RequestBody CoffeeRequestDto coffeeRequestDto){
        return null;
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
