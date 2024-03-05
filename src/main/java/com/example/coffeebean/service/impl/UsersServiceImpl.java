package com.example.coffeebean.service.impl;

import com.example.coffeebean.dto.UsersSignInRequestDto;
import com.example.coffeebean.dto.UsersSignInResponseDto;
import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.entity.Users;
import com.example.coffeebean.repository.UsersRepository;
import com.example.coffeebean.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
//    private final FavoriteCoffeeRepository favoriteCoffeeRepository;
    @Override
    public UsersSignUpResponseDto signUp(UsersSignUpRequestDto usersSignUpRequestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String username = usersSignUpRequestDto.getUsername();
        String password = usersSignUpRequestDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        Users newUser = new Users(username, encodedPassword);
        Users createdUser = usersRepository.save(newUser);
        return createdUser.of();
    }

    @Override
    public UsersSignInResponseDto signIn(UsersSignInRequestDto usersSignInRequestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String username = usersSignInRequestDto.getUsername();
        Users foundUsers = usersRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
        if(passwordEncoder.matches(usersSignInRequestDto.getPassword(), foundUsers.getPassword())){
        }else {

        };
//        Long favoriteCoffeeId = foundUsers.getFavoriteCoffee().getFavoriteCoffeeId();
//        List<FavoriteCoffee> favoriteCoffee = favoriteCoffeeRepository.findFavoriteCoffeesByUserId(foundUsers.getUserId());
        return UsersSignInResponseDto.builder()
                .userId(foundUsers.getUserId())
                .username(foundUsers.getUsername())
//                .favoriteCoffee(favoriteCoffee)
                .thisweekCoffee(foundUsers.getThisweekCoffee())
                .lastweekCoffee(foundUsers.getLastweekCoffee())
                .build();
    }

    @Override
    public Optional<Users> findOne(Long userId){
        return usersRepository.findById(userId);
    }
}
