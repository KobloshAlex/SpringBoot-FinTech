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
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne private User borrower;

  @ManyToOne private User lender;

  private int amount;
  private double interestRate;
  private LocalDate dateLent;
  private LocalDate dateDue;

  public Loan(User lender, LoanApplication loanApplication) {
    this.borrower = loanApplication.getBorrower();
    this.lender = lender;
    this.amount = loanApplication.getAmount();
    this.interestRate = loanApplication.getInterest();
    this.dateLent = LocalDate.now();
    this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTerms());
  }
}
