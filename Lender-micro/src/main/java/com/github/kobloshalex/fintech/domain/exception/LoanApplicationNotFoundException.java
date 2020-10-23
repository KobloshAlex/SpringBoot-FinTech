package com.github.kobloshalex.fintech.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException {
  public LoanApplicationNotFoundException(long loanApplicationId) {
    super("Loan id was not found " + loanApplicationId);
  }
}
