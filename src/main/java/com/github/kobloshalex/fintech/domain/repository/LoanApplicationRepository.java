package com.github.kobloshalex.fintech.domain.repository;

import com.github.kobloshalex.fintech.domain.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {}
