package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.entity.LoanEntity;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Optional;

@Configuration
public class LoanEntityAdapter {

  private final UserRepository userRepository;

  public LoanEntityAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LoanEntity transform(LoanRequest request) {
    Optional<User> user = userRepository.findById(request.getBorrowerId());

    if (user.isPresent()) {
      return new LoanEntity(
          request.getAmount(),
          user.get(),
          request.getDaysToRepair(),
          request.getInterestRate());
    } else {
      throw new UserNotFoundException(request.getBorrowerId());
    }
  }
}
