package com.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.entity.Company;
import com.mm.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController  {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/all")
    public List<Company> getCompanies() {
		return companyService.getAllCompanies();
    }
	
	@GetMapping("/{companyId}")
    public Company getCompany(int companyId) {
		return companyService.getCompany(companyId);
    }
	
	@PostMapping("/add")
    public boolean addCompany(@RequestBody Company company) {
		return companyService.addCompany(company);
    }
}
