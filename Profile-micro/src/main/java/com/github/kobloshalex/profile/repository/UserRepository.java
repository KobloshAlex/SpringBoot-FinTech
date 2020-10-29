package com.github.kobloshalex.profile.repository;

import com.github.kobloshalex.profile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
