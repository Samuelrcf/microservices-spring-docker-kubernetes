package com.eazybanks.loans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybanks.loans.entity.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long>{

	Optional<Loans> findLoansByMobileNumber(String mobileNumber);

}
