package com.github.alexkoblosh.security.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String userId) {
    super("user with id " + userId + " was not found");
  }
}
