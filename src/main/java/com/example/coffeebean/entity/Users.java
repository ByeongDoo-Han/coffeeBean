package com.example.coffeebean.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Users {

    @Id
    private Long userId;
    private String password;
    private String username;
    @OneToOne
    private Coffee thisweekCoffee;
    @OneToOne
    private Coffee lastweekCoffee;
}
