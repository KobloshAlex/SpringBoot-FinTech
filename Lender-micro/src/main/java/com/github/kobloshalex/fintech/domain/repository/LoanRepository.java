package com.github.kobloshalex.fintech.domain.repository;

import com.github.kobloshalex.fintech.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository  extends JpaRepository<Loan, Integer> {
}