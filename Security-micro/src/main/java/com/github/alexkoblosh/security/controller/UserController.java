package com.github.alexkoblosh.security.controller;

import com.github.alexkoblosh.security.exception.UserNotFoundException;
import com.github.alexkoblosh.security.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/validate")
  public String validateTokenAndGetUsername(@RequestHeader("Authorization") final String token) {
    return userRepository
        .findById(token)
        .orElseThrow(() -> new UserNotFoundException(token))
        .getUsername();
  }
}
