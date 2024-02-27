package com.example.coffeebean.entity;

import com.example.coffeebean.dto.UsersSignUpResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long userId;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ManyToOne
    private FavoriteCoffee favoriteCoffee;
    @OneToOne
    private Coffee thisweekCoffee;
    @OneToOne
    private Coffee secondCoffee;
    @OneToOne
    private Coffee lastweekCoffee;

    @Builder
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UsersSignUpResponseDto of(){
        return UsersSignUpResponseDto.builder().userId(this.userId).username(this.username).build();
    }
}
