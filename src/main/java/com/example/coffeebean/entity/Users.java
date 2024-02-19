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
    private Coffee secondCoffee;
    @OneToOne
    private Coffee lastweekCoffee;

    public Users() {

    }
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
