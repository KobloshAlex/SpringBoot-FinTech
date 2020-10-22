package com.github.kobloshalex.fintech.application.controller;

import com.github.kobloshalex.fintech.domain.dto.LoanRequest;
import com.github.kobloshalex.fintech.domain.repository.LoanRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

  private final LoanRepository loanRepository;

  public LoanController(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  @PostMapping(value = "/loan/request")
  public void requestLoan(@RequestBody final LoanRequest loanRequest) {
    System.out.println(loanRequest);
  }
}
