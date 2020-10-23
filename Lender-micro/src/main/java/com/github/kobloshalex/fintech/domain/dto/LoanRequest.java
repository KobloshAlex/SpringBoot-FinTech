package com.github.kobloshalex.fintech.domain.dto;

import java.util.Objects;

public class LoanRequest {
  private final int amount;
  private final long borrowerId;
  private final int daysToRepair;
  private final double interestRate;

  public LoanRequest(int amount, int borrowerId, int daysToRepair, double interestRate) {
    this.amount = amount;
    this.borrowerId = borrowerId;
    this.daysToRepair = daysToRepair;
    this.interestRate = interestRate;
  }

  public int getAmount() {
    return amount;
  }

  public long getBorrowerId() {
    return borrowerId;
  }

  public int getDaysToRepair() {
    return daysToRepair;
  }

  public double getInterestRate() {
    return interestRate;
  }

  @Override
  public String toString() {
    return "LoanRequest{"
        + "amount="
        + amount
        + ", borrowerId="
        + borrowerId
        + ", daysToRepair="
        + daysToRepair
        + ", interestRate="
        + interestRate
        + '}';
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
        && borrowerId == that.borrowerId
        && daysToRepair == that.daysToRepair
        && Double.compare(that.interestRate, interestRate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, borrowerId, daysToRepair, interestRate);
  }
}
