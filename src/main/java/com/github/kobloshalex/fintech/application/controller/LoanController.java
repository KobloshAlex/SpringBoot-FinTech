package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.entity.LoanApplication;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.LoanApplicationRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import com.github.kobloshalex.fintech.domain.service.LoanApplicationAdapter;
import com.github.kobloshalex.fintech.domain.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

  private final LoanApplicationRepository loanApplicationRepository;
  private final UserRepository userRepository;
  private final LoanApplicationAdapter loanApplicationAdapter;
  private final LoanService loanService;

  public LoanController(
      LoanApplicationRepository loanApplicationRepository,
      UserRepository userRepository,
      LoanApplicationAdapter loanApplicationAdapter,
      LoanService loanService) {
    this.loanApplicationRepository = loanApplicationRepository;
    this.userRepository = userRepository;
    this.loanApplicationAdapter = loanApplicationAdapter;
    this.loanService = loanService;
  }

  @PostMapping(value = "/loan/request")
  public void requestLoan(@RequestBody final LoanRequest loanRequest) {
    loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest));
  }

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping(value = "/loans")
  public List<LoanApplication> getAllLoans() {
    return loanApplicationRepository.findAll();
  }

  @PostMapping(value = "/loan/accept/{loanApplicationId}/{lenderId}")
  public void acceptLoan(
      @PathVariable final String lenderId, @PathVariable final String loanApplicationId) {
    loanService.acceptLoan(Long.parseLong(loanApplicationId), Long.parseLong(lenderId));
  }
}
