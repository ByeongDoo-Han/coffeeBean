package com.example.coffeebean.repository;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    @DisplayName("user가 db에 잘 저장되는지 확인")
    @Transactional
    void saveUsersTest(){
        //given
        Users users1;
        Users savedUsers1;
        users1 = new UsersSignUpRequestDto("abc", "123").toEntity();
        //when
        savedUsers1 = usersRepository.save(users1);
        System.out.println("=======================================");
        System.out.println(savedUsers1.getUserId());
        System.out.println("=======================================");
        //then
        Assertions.assertThat(users1).isSameAs(savedUsers1);
        Assertions.assertThat(users1.getUsername()).isEqualTo(savedUsers1.getUsername());
        Assertions.assertThat(savedUsers1.getUserId()).isNotNull();
        Assertions.assertThat(usersRepository.count()).isEqualTo(1);
    }
}