package com.example.coffeebean.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coffee_id", nullable = false)
    private Long coffeeId;
    @ManyToOne
    private FavoriteCoffee favoriteCoffee;
    @Column(name = "coffee_name", nullable = false)
    private String coffeeName;
    @Column(name = "coffee_category", nullable = false)
    private String coffeeCategory;
    @Column(name = "coffee_temperature", nullable = false)
    private CoffeeTemperature coffeeTemperature;
    @Column(name = "add_shot", nullable = false)
    private Boolean addShot;
    @Column(name = "coffee_size", nullable = false)
    private CoffeeSize coffeeSize;
}
