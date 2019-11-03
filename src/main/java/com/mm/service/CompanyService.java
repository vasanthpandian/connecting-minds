package com.mm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mm.entity.Company;

@Service
public interface CompanyService  {
	
    public List<Company> getAllCompanies();
    
    public Company getCompany(int companyId);
	
    public boolean addCompany(Company company);
    
    public boolean deleteCompany(Company company);
    
    public boolean updateCompany(Company company);
    
    public boolean isCompanyExists(int companyId);
}
