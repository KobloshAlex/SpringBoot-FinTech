package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.entity.Loan;
import com.github.kobloshalex.fintech.domain.entity.LoanApplication;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.repository.LoanApplicationRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import com.github.kobloshalex.fintech.domain.service.LoanApplicationAdapter;
import com.github.kobloshalex.fintech.domain.service.LoanService;
import com.github.kobloshalex.fintech.domain.service.TokenValidationService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoanController {

  private final LoanApplicationRepository loanApplicationRepository;
  private final UserRepository userRepository;
  private final LoanApplicationAdapter loanApplicationAdapter;
  private final LoanService loanService;
  private final TokenValidationService tokenValidationService;

  public LoanController(
      LoanApplicationRepository loanApplicationRepository,
      UserRepository userRepository,
      LoanApplicationAdapter loanApplicationAdapter,
      LoanService loanService,
      TokenValidationService tokenValidationService) {
    this.loanApplicationRepository = loanApplicationRepository;
    this.userRepository = userRepository;
    this.loanApplicationAdapter = loanApplicationAdapter;
    this.loanService = loanService;
    this.tokenValidationService = tokenValidationService;
  }

  @PostMapping(value = "/loan/request")
  public void requestLoan(@RequestBody final LoanRequest loanRequest, HttpServletRequest request) {
    User borrower =
        tokenValidationService.validateTokenAndGetUsername(
            request.getHeader(HttpHeaders.AUTHORIZATION));
    loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest, borrower));
  }

  @GetMapping(value = "loan/borrower")
  public List<Loan> findAllBorrowerLoans(@RequestHeader final String authToken) {
    final User borrower = tokenValidationService.validateTokenAndGetUsername(authToken);
    return loanService.findAllBorrowers(borrower);
  }

  @GetMapping(value = "loan/lent")
  public List<Loan> findAllLentLoans(@RequestHeader final String authToken) {
    final User lent = tokenValidationService.validateTokenAndGetUsername(authToken);
    return loanService.findAllLenders(lent);
  }

  @GetMapping(value = "/loans-app")
  public List<LoanApplication> getAllLoansApplications(HttpServletRequest request) {
    tokenValidationService.validateTokenAndGetUsername(
        request.getHeader(HttpHeaders.AUTHORIZATION));
    return loanApplicationRepository.findAll();
  }

  @PostMapping(value = "/loan/accept/{loanApplicationId}")
  public void acceptLoan(@PathVariable final String loanApplicationId, HttpServletRequest request) {
    User user =
        tokenValidationService.validateTokenAndGetUsername(
            request.getHeader(HttpHeaders.AUTHORIZATION));
    loanService.acceptLoan(Long.parseLong(loanApplicationId), user.getUsername());
  }

  @GetMapping(value = "/loans")
  public List<Loan> getAllLoans() {
    return loanService.getLoans();
  }
}
