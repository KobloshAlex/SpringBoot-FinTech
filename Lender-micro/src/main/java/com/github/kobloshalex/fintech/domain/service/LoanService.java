package com.github.kobloshalex.fintech.domain.service;

import com.github.kobloshalex.fintech.domain.entity.Currency;
import com.github.kobloshalex.fintech.domain.entity.Loan;
import com.github.kobloshalex.fintech.domain.entity.LoanApplication;
import com.github.kobloshalex.fintech.domain.entity.Money;
import com.github.kobloshalex.fintech.domain.entity.User;
import com.github.kobloshalex.fintech.domain.exception.LoanApplicationNotFoundException;
import com.github.kobloshalex.fintech.domain.exception.UserNotFoundException;
import com.github.kobloshalex.fintech.domain.repository.LoanApplicationRepository;
import com.github.kobloshalex.fintech.domain.repository.LoanRepository;
import com.github.kobloshalex.fintech.domain.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public void acceptLoan(final long loanApplicationId, final String lenderUsername) {
    final User lender = findLenderById(lenderUsername);
    final LoanApplication loanApplication = findLoanApplication(loanApplicationId);
    final User borrower = loanApplication.getBorrower();
    final Money money = new Money(Currency.USD, loanApplication.getAmount());
    lender.withDraw(money);
    borrower.topUp(money);
    loanRepository.save(new Loan(lender, loanApplication));
  }

  public List<Loan> findAllBorrowers(User borrower) {
   return loanRepository.findAllByBorrower(borrower);
  }

  public List<Loan> findAllLenders(User lender) {
    return loanRepository.findAllByLender(lender);
  }

  private LoanApplication findLoanApplication(long loanApplicationId) {
    return loanApplicationRepository
        .findById(loanApplicationId)
        .orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId));
  }

  private User findLenderById(String lenderUsername) {
    return userRepository
        .findById(lenderUsername)
        .orElseThrow(() -> new UserNotFoundException(lenderUsername));
  }

  public final List<Loan> getLoans() {
    return loanRepository.findAll();
  }
}
