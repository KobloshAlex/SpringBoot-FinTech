package com.github.kobloshalex.fintech.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class User {
  @Id private String username;

  private String firstName;
  private String lastName;
  private int age;
  private String occupation;

  @OneToOne(cascade = CascadeType.ALL)
  private Balance balance;

  public void withDraw(final Money money) {
    balance.withdraw(money);
  }

  public void topUp(final Money money) {
    balance.topUp(money);
  }
}
