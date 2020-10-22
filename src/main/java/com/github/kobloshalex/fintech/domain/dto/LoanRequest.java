package com.github.kobloshalex.fintech.domain.dto;

import com.github.kobloshalex.fintech.domain.entity.User;

import java.time.Duration;
import java.util.Objects;

public class LoanRequest {
  private final int amount;
  private final User borrower;
  private final Duration repaymentTerms;
  private final double interest;

  public LoanRequest(int amount, User borrower, Duration repaymentTerms, double interest) {
    this.amount = amount;
    this.borrower = borrower;
    this.repaymentTerms = repaymentTerms;
    this.interest = interest;
  }

  public int getAmount() {
    return amount;
  }

  public User getBorrower() {
    return borrower;
  }

  public Duration getRepaymentTerms() {
    return repaymentTerms;
  }

  public double getInterest() {
    return interest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LoanRequest)) {
      return false;
    }
    LoanRequest that = (LoanRequest) o;
    return amount == that.amount
        && Double.compare(that.interest, interest) == 0
        && Objects.equals(borrower, that.borrower)
        && Objects.equals(repaymentTerms, that.repaymentTerms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, borrower, repaymentTerms, interest);
  }

  @Override
  public String toString() {
    return "LoanRequest{"
        + "amount="
        + amount
        + ", borrower="
        + borrower
        + ", repaymentTerms="
        + repaymentTerms
        + ", interest="
        + interest
        + '}';
  }
}
