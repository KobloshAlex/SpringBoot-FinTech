package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
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
  private final UserRepository userRepository;
  private final RestTemplate restTemplate;
  private final String securityContextBaseUrl;

  public TokenValidationService(
      UserRepository userRepository,
      RestTemplate restTemplate,
      @Value("${security.baseurl}") String securityContextBaseUrl) {
    this.userRepository = userRepository;
    this.restTemplate = restTemplate;
    this.securityContextBaseUrl = securityContextBaseUrl;
  }

  public User validateTokenAndGetUsername(final String token) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
    HttpEntity httpEntity = new HttpEntity(httpHeaders);

    ResponseEntity<String> response =
        restTemplate.exchange(
            securityContextBaseUrl + "/users/validate", HttpMethod.POST, httpEntity, String.class);

    if (response.getStatusCode().equals(HttpStatus.OK)) {
      return userRepository
          .findById(Objects.requireNonNull(response.getBody()))
          .orElseThrow(() -> new UserNotFoundException(response.getBody()));
    }
    throw new RuntimeException("Invalid token");
  }
}
