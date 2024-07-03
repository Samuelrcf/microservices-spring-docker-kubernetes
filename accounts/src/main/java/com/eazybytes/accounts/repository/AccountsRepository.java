package com.eazybytes.accounts.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.accounts.entity.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, UUID>{

}
