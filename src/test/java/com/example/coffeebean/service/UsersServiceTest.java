package com.example.coffeebean.service;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import com.example.coffeebean.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsersServiceTest {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersService usersService;


    @Test
    void signUp(){
        //given
        Users users = Users.builder().username("abc").password("123").build();
        UsersSignUpRequestDto dto = UsersSignUpRequestDto.builder()
                .username(users.getUsername())
                .password(users.getPassword())
                .build();
        //when
        Long userId = usersService.signUp(dto).getUserId();

        //then
        Users findUsers = usersService.findOne(userId).get();
        assertThat(users.getUsername()).isEqualTo(findUsers.getUsername());
    }

    @Test
    void signIn(){

    }
}