package com.github.kobloshalex.fintech.domain.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LoanRequest {
  private final int amount;
  private final int daysToRepair;
  private final double interestRate;

  public int getAmount() {
    return amount;
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
        && daysToRepair == that.daysToRepair
        && Double.compare(that.interestRate, interestRate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, daysToRepair, interestRate);
  }
}
