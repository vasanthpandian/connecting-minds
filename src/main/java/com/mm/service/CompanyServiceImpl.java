package com.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.entity.Company;
import com.mm.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
    @Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies(){
		return companyRepository.findAll();
    }
	
	public Company getCompany(int companyId) {
    	return companyRepository.findAll().get(0);
    }
	
    public boolean addCompany(Company company) {
    	companyRepository.save(company);
    	return true;
    }
    
    public boolean deleteCompany(Company company) {
    	companyRepository.delete(company);
    	return true;
    }
    
    public boolean updateCompany(Company company) {
    	companyRepository.save(company);
    	return true;
    }

	public boolean isCompanyExists(int companyId) {
		boolean isCompanyExists = false;
		Company company = getCompany(companyId);
		if (company != null && company.getCompanyId() != null) {
			isCompanyExists = true;
		}
		return isCompanyExists;
	}
}
