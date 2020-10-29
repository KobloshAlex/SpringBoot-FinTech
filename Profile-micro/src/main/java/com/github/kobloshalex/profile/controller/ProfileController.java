package com.github.kobloshalex.profile.controller;

import com.github.kobloshalex.profile.model.User;
import com.github.kobloshalex.profile.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

  private final UserRepository userRepository;

  public ProfileController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> findAllProfiles() {
    return userRepository.findAll();
  }

  @PostMapping("/user")
  public void saveUser(@RequestBody final User user) {
    user.setRegisteredSince(LocalDate.now());
    userRepository.save(user);
  }

  @PutMapping("/users")
  public void updateUser(@RequestBody final User user) {
    userRepository.save(user);
  }
}
