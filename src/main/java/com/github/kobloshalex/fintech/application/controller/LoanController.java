package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.entity.LoanEntity;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.LoanEntityRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import com.github.kobloshalex.fintech.domain.service.LoanEntityAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

  private final LoanEntityRepository loanEntityRepository;
  private final UserRepository userRepository;
  private final LoanEntityAdapter loanEntityAdapter;

  public LoanController(LoanEntityRepository loanEntityRepository, UserRepository userRepository, LoanEntityAdapter loanEntityAdapter) {
    this.loanEntityRepository = loanEntityRepository;
    this.userRepository = userRepository;
    this.loanEntityAdapter = loanEntityAdapter;
  }

  @PostMapping(value = "/loan/request")
  public void requestLoan(@RequestBody final LoanRequest loanRequest) {
    loanEntityRepository.save(loanEntityAdapter.transform(loanRequest));
  }

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping(value = "/loans")
  public List<LoanEntity> getAllLoans() {
    return loanEntityRepository.findAll();
  }
}
