package com.example.coffeebean.service.impl;

import com.example.coffeebean.dto.UsersSignInRequestDto;
import com.example.coffeebean.dto.UsersSignInResponseDto;
import com.example.coffeebean.dto.UsersSignUpRequestDto;
import com.example.coffeebean.dto.UsersSignUpResponseDto;
import com.example.coffeebean.entity.Users;
import com.example.coffeebean.repository.UsersRepository;
import com.example.coffeebean.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
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
    public UsersSignInResponseDto signIn(HttpServletRequest request, UsersSignInRequestDto usersSignInRequestDto) throws Exception {

        //패스워드 인코더
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //username으로 조회
        String username = usersSignInRequestDto.getUsername();
        Users foundUsers = usersRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);

        //비밀번호 match 확인
        if(!passwordEncoder.matches(usersSignInRequestDto.getPassword(), foundUsers.getPassword())){
            throw new Exception("비밀번호가 일치하지 않습니다.");
        };

        //new session
        HttpSession session = request.getSession();
        session.setAttribute("session-user", foundUsers);
        System.out.println(session);
//        Long favoriteCoffeeId = foundUsers.getFavoriteCoffee().getFavoriteCoffeeId();
//        List<FavoriteCoffee> favoriteCoffee = favoriteCoffeeRepository.findAllById(favoriteCoffeeId).orElseThrow(NoSuchElementException::new);
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
