package com.example.coffeebean.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Coffee {

    @Id
    private Long coffeeId;
    private String coffeeName;
    private String coffeeCategory;
    private CoffeeTemperature coffeeTemperature;
    private Boolean addShot;
    private CoffeeSize coffeeSize;

}
