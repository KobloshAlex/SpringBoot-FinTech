package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers(HttpServletRequest request) {
//    tokenValidationService.validateTokenAndGetUsername(
//        request.getHeader(HttpHeaders.AUTHORIZATION));
        return userRepository.findAll();
    }
}
