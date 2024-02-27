package com.example.coffeebean.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "favorite_coffee")
public class FavoriteCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteCoffeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Coffee coffeeId;
}
