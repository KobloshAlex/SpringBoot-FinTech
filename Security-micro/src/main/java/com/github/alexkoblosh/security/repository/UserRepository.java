package com.github.alexkoblosh.security.repository;

import com.github.alexkoblosh.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
