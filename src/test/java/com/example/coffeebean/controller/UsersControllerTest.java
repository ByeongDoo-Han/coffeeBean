package com.example.coffeebean.controller;

import com.example.coffeebean.dto.UsersSignInRequestDto;
import com.example.coffeebean.dto.UsersSignInResponseDto;
import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.entity.Coffee;
import com.example.coffeebean.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UsersService usersService;

    @Test
    @DisplayName("회원가입 테스트")
//    @WithMockUser
    void signUp() throws Exception{
        UsersSignUpRequestDto dto = UsersSignUpRequestDto.builder().username("abc").password("123").build();

        given(usersService.signUp(any())).willReturn(new UsersSignUpResponseDto(1L, dto.getUsername()));

        mockMvc
                .perform(post("/signUp")
                        .content(objectMapper.writeValueAsString(dto))
//                        .header("Access-Control-Allow-Origin", "*")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.username").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 테스트")
    void signIn() throws Exception {
        UsersSignInRequestDto dto = UsersSignInRequestDto.builder()
                .username("abc")
                .password("1234")
                .build();
        given(usersService.signIn(any())).willReturn(
                UsersSignInResponseDto.builder()
                        .userId(1L)
                        .username("abc")
                        .lastweekCoffee(new Coffee())
                        .secondCoffee(new Coffee())
                        .thisweekCoffee(new Coffee())
                        .build());


        mockMvc.perform(post("/signIn")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}