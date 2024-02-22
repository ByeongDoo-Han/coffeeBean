package com.example.coffeebean.repository;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

@DataJpaTest
@EnableJpaRepositories(bootstrapMode = BootstrapMode.LAZY)
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    public void teardown() {
        usersRepository.deleteAll();
        usersRepository.flush();
    }

    @Test
    @DisplayName("user가 db에 잘 저장되는지 확인")
    void saveUsersTest(){
        //given
        Users users1 = new UsersSignUpRequestDto("abc", "123").toEntity();
        //when
        Users savedUsers1 = usersRepository.save(users1);
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