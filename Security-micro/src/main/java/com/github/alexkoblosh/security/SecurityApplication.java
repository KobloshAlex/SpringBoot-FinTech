package com.github.alexkoblosh.security;

import com.github.alexkoblosh.security.repository.UserRepository;
import com.github.alexkoblosh.security.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecurityApplication.class, args);
  }

  @Bean
  public CommandLineRunner fillUsers(UserRepository userRepository) {
    return args -> {
      userRepository.save(new User("Alex", "123"));
      userRepository.save(new User("Bob", "123"));
      userRepository.save(new User("Kim", "123"));
    };
  }
}
