package com.github.alexkoblosh.security.controller;

import com.github.alexkoblosh.security.exception.UserNotFoundException;
import com.github.alexkoblosh.security.repository.UserRepository;
import com.github.alexkoblosh.security.service.NotificationService;
import com.github.alexkoblosh.security.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;
  private final NotificationService notificationService;

  public UserController(UserRepository userRepository, NotificationService notificationService) {
    this.userRepository = userRepository;
    this.notificationService = notificationService;
  }

  @PostMapping("/register")
  public void register(User user) {
    //user.setUsername("test");
    userRepository.save(user);
    notificationService.sendMessage(user);
  }

  @PostMapping("/validate")
  public String validateTokenAndGetUsername(@RequestHeader("Authorization") final String token) {
    return userRepository
        .findById(token)
        .orElseThrow(() -> new UserNotFoundException(token))
        .getUsername();
  }
}
