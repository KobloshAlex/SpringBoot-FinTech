package com.github.kobloshalex.fintech.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

@Entity
@ToString
@EqualsAndHashCode
public class Balance {

  @MapKeyClass(Currency.class)
  @OneToMany(targetEntity = Money.class, cascade = CascadeType.ALL)
  @Getter
  private final Map<Currency, Money> moneyMap = new HashMap<>();

  @Id @GeneratedValue private long id;

  public void topUp(final Money money) {
    if (moneyMap.get(money.getCurrency()) == null) {
      moneyMap.put(money.getCurrency(), money);
    } else {
      moneyMap.put(money.getCurrency(), moneyMap.get(money.getCurrency()).add(money));
    }
  }

  public void withdraw(final Money money) {
    final Money moneyInBalance = moneyMap.get(money.getCurrency());
    if (moneyInBalance == null) {
      throw new IllegalArgumentException();
    } else {
      moneyMap.put(money.getCurrency(), moneyMap.get(money.getCurrency()).minus(money));
    }
  }
}
