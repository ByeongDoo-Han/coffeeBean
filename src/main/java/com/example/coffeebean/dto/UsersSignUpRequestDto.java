package com.example.coffeebean.dto;

import com.example.coffeebean.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsersSignUpRequestDto {
    public String username;
    public String password;

    public Users toEntity(){
        return Users.builder().username(this.username).password(this.password).build();
    }
}
