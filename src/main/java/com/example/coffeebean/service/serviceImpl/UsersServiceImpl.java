package com.example.coffeebean.service.serviceImpl;

import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.entity.Users;
import com.example.coffeebean.repository.UsersRepository;
import com.example.coffeebean.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public ResponseEntity<Users> signUp(UsersSignUpRequestDto usersSignUpRequestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String username = usersSignUpRequestDto.username;
        String password = usersSignUpRequestDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        Users newUser = new Users(username, encodedPassword);
        Users createdUser = usersRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }
}
