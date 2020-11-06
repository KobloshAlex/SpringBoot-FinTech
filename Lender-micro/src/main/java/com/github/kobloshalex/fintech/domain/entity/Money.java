package com.github.kobloshalex.fintech.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
public final class Money {

  @Id @GeneratedValue private long id;

  @Getter private Currency currency;
  @Getter private double amount;

  public Money(Currency currency, double amount) {
    this.currency = currency;
    this.amount = amount;
  }

  public Money add(final Money money) {
    if (currency != money.getCurrency()) {
      throw new IllegalArgumentException();
    }
    return new Money(currency, amount + money.getAmount());
  }

  public Money minus(final Money money) {
    if (currency != money.getCurrency() || amount < money.getAmount()) {
      throw new IllegalArgumentException();
    }
    return new Money(currency, amount - money.getAmount());
  }
}
