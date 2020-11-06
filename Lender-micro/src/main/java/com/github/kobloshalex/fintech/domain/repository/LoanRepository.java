package com.github.kobloshalex.fintech.domain.repository;

import com.github.kobloshalex.fintech.domain.entity.Loan;
import com.github.kobloshalex.fintech.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

  List<Loan> findAllByBorrower(User borrower);

  List<Loan> findAllByLender(User lender);
}
