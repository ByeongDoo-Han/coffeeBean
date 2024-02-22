package com.example.coffeebean.dto;

import com.example.coffeebean.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersSignInResponseDto {
    private Long userId;
    private String username;
    private List<Coffee> favoriteCoffee;
    private Coffee thisweekCoffee;
    private Coffee secondCoffee;
    private Coffee lastweekCoffee;
}
