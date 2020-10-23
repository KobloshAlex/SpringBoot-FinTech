package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.entity.Loan;
import com.github.kobloshalex.fintech.domain.entity.LoanApplication;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.LoanApplicationNotFoundException;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.LoanApplicationRepository;
import com.github.kobloshalex.fintech.domain.repository.LoanRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanService {

  private final LoanRepository loanRepository;
  private final LoanApplicationRepository loanApplicationRepository;
  private final UserRepository userRepository;

  public LoanService(
      LoanRepository loanRepository,
      LoanApplicationRepository loanApplicationRepository,
      UserRepository userRepository) {
    this.loanRepository = loanRepository;
    this.loanApplicationRepository = loanApplicationRepository;
    this.userRepository = userRepository;
  }

  public final void acceptLoan(final long loanApplicationId, final long lenderId) {
    User lender =
        userRepository.findById(lenderId).orElseThrow(() -> new UserNotFoundException(lenderId));
    LoanApplication loanApplication = loanApplicationRepository
            .findById(loanApplicationId)
            .orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId));
    loanRepository.save(new Loan(lender, loanApplication));
  }

  public final List<Loan> getLoans(){
    return loanRepository.findAll();
  }
}
