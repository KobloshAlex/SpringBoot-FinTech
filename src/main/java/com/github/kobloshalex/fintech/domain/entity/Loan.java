package com.github.kobloshalex.fintech.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
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

  public Loan() {}

  public Loan(User lender, LoanApplication loanApplication) {
    this.borrower = loanApplication.getBorrower();
    this.lender = lender;
    this.amount = loanApplication.getAmount();
    this.interestRate = loanApplication.getInterest();
    this.dateLent = LocalDate.now();
    this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTerms());
  }

  public int getId() {
    return id;
  }

  public Loan setId(int id) {
    this.id = id;
    return this;
  }

  public User getBorrower() {
    return borrower;
  }

  public Loan setBorrower(User borrower) {
    this.borrower = borrower;
    return this;
  }

  public User getLender() {
    return lender;
  }

  public Loan setLender(User lender) {
    this.lender = lender;
    return this;
  }

  public int getAmount() {
    return amount;
  }

  public Loan setAmount(int amount) {
    this.amount = amount;
    return this;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public Loan setInterestRate(double interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  public LocalDate getDateLent() {
    return dateLent;
  }

  public Loan setDateLent(LocalDate dateLent) {
    this.dateLent = dateLent;
    return this;
  }

  public LocalDate getDateDue() {
    return dateDue;
  }

  public Loan setDateDue(LocalDate dateDue) {
    this.dateDue = dateDue;
    return this;
  }
}
