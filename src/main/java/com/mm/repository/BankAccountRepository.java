package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.entity.BankAccountDetails;

public interface BankAccountRepository extends JpaRepository<BankAccountDetails, Long> {

}
