package com.github.kobloshalex.profile.event;

import com.github.kobloshalex.profile.model.User;
import com.github.kobloshalex.profile.repository.UserRepository;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserRegisterEventHandler {

  private final UserRepository userRepository;
  private final Gson gson;

  public UserRegisterEventHandler(UserRepository userRepository, Gson gson) {
    this.userRepository = userRepository;
    this.gson = gson;
  }

  public void handleUserRegister(String userDetails) {
    User user = gson.fromJson(userDetails, User.class);
    userRepository.save(user);
    log.info("user {} registered", user.getUsername());
  }
}
