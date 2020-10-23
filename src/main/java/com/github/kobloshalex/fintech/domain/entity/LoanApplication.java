package com.github.kobloshalex.fintech.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public final class LoanApplication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int amount;
  private int repaymentTerms;
  private double interest;
  @ManyToOne private User borrower;

  public LoanApplication() {}

  public LoanApplication(int amount, User borrower, int repaymentTerms, double interest) {
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

  public int getRepaymentTerms() {
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
    if (!(o instanceof LoanApplication)) {
      return false;
    }
    LoanApplication that = (LoanApplication) o;
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
    return "LoadRequest{"
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

  public long getId() {
    return id;
  }

  public LoanApplication setId(long id) {
    this.id = id;
    return this;
  }
}
