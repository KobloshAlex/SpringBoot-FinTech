package com.github.kobloshalex.fintech;

import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FintechApplication {

  public static void main(String[] args) {
    SpringApplication.run(FintechApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public CommandLineRunner sampleData(UserRepository userRepository) {
    return args -> {
      userRepository.save(new User("Alex", "Alex", "Kob", 21, "Medd st"));
      userRepository.save(new User("Bob", "Rob", "Rob", 31, "Winn st"));
      userRepository.save(new User("Jack", "Jack", "Green", 51, "Arrow st"));
    };
  }
}
