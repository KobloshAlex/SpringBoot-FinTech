package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.entity.Money;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceService {

  private final UserRepository userRepository;

  public BalanceService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void topUpBalance(final Money money, String authToken) {
    final User user = findUserByAuthToken(authToken);
    user.topUp(money);
  }

  @Transactional
  public void withdrawBalance(final Money money, String authToken) {
    final User user = findUserByAuthToken(authToken);
    user.withDraw(money);
  }

  private User findUserByAuthToken(String authToken) {
    return userRepository
        .findById(authToken)
        .orElseThrow(() -> new UserNotFoundException(authToken));
  }
}
