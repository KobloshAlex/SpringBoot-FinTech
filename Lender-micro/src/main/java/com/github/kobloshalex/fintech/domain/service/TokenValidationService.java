package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class TokenValidationService {
  private static final String securityContextBaseUrl = "http://localhost:8082";
  private final UserRepository userRepository;
  private final RestTemplate restTemplate = new RestTemplate();

  public TokenValidationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User validateTokenAndGetUsername(final String token) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
    HttpEntity httpEntity = new HttpEntity(httpHeaders);

    ResponseEntity<String> response =
        restTemplate.exchange(
            "http://localhost:8082/users/validate", HttpMethod.POST, httpEntity, String.class);

    if (response.getStatusCode().equals(HttpStatus.OK)) {
      return userRepository
          .findById(response.getBody())
          .orElseThrow(() -> new UserNotFoundException(response.getBody()));
    }
    throw new RuntimeException("Invalid token");
  }
}
