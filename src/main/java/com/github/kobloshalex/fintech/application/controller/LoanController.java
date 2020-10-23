package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.LoanRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

  private final LoanRepository loanRepository;
  private final UserRepository userRepository;

  public LoanController(LoanRepository loanRepository, UserRepository userRepository) {
    this.loanRepository = loanRepository;
    this.userRepository = userRepository;
  }

  @PostMapping(value = "/loan/request")
  public void requestLoan(@RequestBody final LoanRequest loanRequest) {
    System.out.println(loanRequest);
  }

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
