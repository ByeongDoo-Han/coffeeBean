package com.example.coffeebean.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersSignUpResponseDto {
    private Long userId;
    private String username;
}
