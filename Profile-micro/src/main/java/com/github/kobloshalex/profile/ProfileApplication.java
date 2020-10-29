package com.github.kobloshalex.profile;

import com.github.kobloshalex.profile.model.User;
import com.github.kobloshalex.profile.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ProfileApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProfileApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(UserRepository userRepository) {
    return args -> {
      userRepository.save(new User("Alex", "Alex", "Kob", 21, "CEO", LocalDate.now()));
    };
  }
}
