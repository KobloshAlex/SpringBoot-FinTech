package com.github.kobloshalex.fintech.domain.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String username) {
    super("User id was not found " + username);
  }
}
