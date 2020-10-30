package com.github.kobloshalex.fintech.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public final class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String username;

  private String firstName;
  private String lastName;
  private int age;
  private String occupation;
}
