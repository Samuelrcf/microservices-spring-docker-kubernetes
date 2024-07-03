package com.eazybytes.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.accounts.entity.Customer;

@Repository
public interface AccountsRepository extends JpaRepository<Customer, Long>{

}
