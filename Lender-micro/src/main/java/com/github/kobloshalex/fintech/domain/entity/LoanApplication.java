package com.github.kobloshalex.fintech.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public final class LoanApplication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int amount;
  private int repaymentTerms;
  private double interest;
  @ManyToOne private User borrower;

  public LoanApplication(int amount, User borrower, int repaymentTerms, double interest) {
    this.amount = amount;
    this.borrower = borrower;
    this.repaymentTerms = repaymentTerms;
    this.interest = interest;
  }
}
