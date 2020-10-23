package com.github.kobloshalex.fintech.domain.repository;

import com.github.kobloshalex.fintech.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
