package com.github.alexkoblosh.security.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class UserDto {
  private String username;
  @Setter private String password;
  private String firstName;
  private String lastName;
  private int age;
  private String occupation;
}
