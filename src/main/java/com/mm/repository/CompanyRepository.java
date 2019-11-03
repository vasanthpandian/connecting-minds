package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
