package com.example.coffeebean.controller;

import com.example.coffeebean.entity.Coffee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeBeanController {

    @PostMapping("/coffeeMenu")
    public List<Coffee> getCoffeeMenu(){
        return null;
    }
}
