package com.eazybytes.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.eazybytes.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long>{

	Optional<Accounts> findByCustomerId(Long id);
	
	@Transactional
	@Modifying
	void deleteByCustomerId(Long id);
}
