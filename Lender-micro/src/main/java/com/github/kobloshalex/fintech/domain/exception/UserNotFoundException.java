package com.github.kobloshalex.fintech.domain.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(long userId) {
    super("User id was not found " + userId);
  }
}
