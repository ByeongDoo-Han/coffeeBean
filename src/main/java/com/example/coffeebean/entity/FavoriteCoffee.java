package com.example.coffeebean.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteCoffeeId;
    private Long userId;
    private Long coffeeId;
}
