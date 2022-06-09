package com.example.WorkShop.service;

import com.example.WorkShop.model.User;
import com.example.WorkShop.model.dto.UserRegistrationDto;
import com.example.WorkShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository repository;

    @Autowired
    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(UserRegistrationDto userRegistrationDto){
        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())){
            throw new RuntimeException("password.match");
        }

        Optional<User> byEmail = this.repository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()){
            throw new RuntimeException("email.used");
        }

        User user = new User(
                userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getFullname(),
                userRegistrationDto.getAge()
        );

        this.repository.save(user);
    }
}
