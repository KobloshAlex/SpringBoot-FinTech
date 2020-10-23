package com.github.kobloshalex.fintech.domain.repository;

import com.github.kobloshalex.fintech.domain.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanEntityRepository extends JpaRepository<LoanEntity, Long> {}
