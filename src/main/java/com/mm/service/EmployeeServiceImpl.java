package com.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mm.entity.BankAccountDetails;
import com.mm.entity.Employee;
import com.mm.repository.BankAccountRepository;
import com.mm.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
    @Autowired
	private EmployeeRepository employeeRepository;
    
    @Autowired
    private BankAccountRepository bankAccountRepository;
    
    @Autowired
    private CompanyService companyService;
	
    public Employee getEmployee(final int empId){
		return employeeRepository.findByEmpId(empId);
    }
    
    public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
    }
	
    public boolean addEmployee(final Employee employee) {
    	boolean isAdded = false;
    	if(!StringUtils.isEmpty(employee.getCompany().getCompanyId()) 
    			&& companyService.isCompanyExists(Integer.valueOf(employee.getCompany().getCompanyId()))) {
    		bankAccountRepository.save(employee.getBankAccountDetails());
        	employeeRepository.save(employee);
        	isAdded = true;
    	}
    	return isAdded;
    }
    
    public boolean deleteEmployee(final Employee employee) {
    	employeeRepository.delete(employee);
    	return true;
    }
    
    public boolean updateEmployee(final Employee employee) {
    	boolean employeeUpdated = false;
    	Employee employeeToUpdate = employeeRepository.findByEmpId(employee.getEmpId());
    	if (employeeToUpdate != null) {
	    	if (!StringUtils.isEmpty(employee.getSalary())) {
	    		employeeToUpdate.setSalary(employee.getSalary());
	    	}
    		if(!StringUtils.isEmpty(employee.getSurcharge())) {
    			employeeToUpdate.setSurcharge(employee.getSurcharge());
    		}
    		if (!StringUtils.isEmpty(employee.getCompany())) {
	    		employeeToUpdate.setCompany(employee.getCompany());
	    	}
    		if (!StringUtils.isEmpty(employee.getEmail())) {
	    		employeeToUpdate.setEmail(employee.getEmail());
	    	}
    		if (!StringUtils.isEmpty(employee.getMobile())) {
	    		employeeToUpdate.setMobile(employee.getMobile());
	    	}
    		if(employee.getBankAccountDetails() != null) {
    			BankAccountDetails bankAccountDetailsToUpdate = employeeToUpdate.getBankAccountDetails();
    			if (!StringUtils.isEmpty(employee.getBankAccountDetails().getBank())) {
    				bankAccountDetailsToUpdate.setBank(employee.getBankAccountDetails().getBank());
    			}
    			if (!StringUtils.isEmpty(employee.getBankAccountDetails().getAccountNumber())) {
    				bankAccountDetailsToUpdate.setAccountNumber(employee.getBankAccountDetails().getAccountNumber());
    			}
    			if (!StringUtils.isEmpty(employee.getBankAccountDetails().getIfsc())) {
    				bankAccountDetailsToUpdate.setIfsc(employee.getBankAccountDetails().getIfsc());
    			}
    			if (!StringUtils.isEmpty(employee.getBankAccountDetails().getBranch())) {
    				bankAccountDetailsToUpdate.setBranch(employee.getBankAccountDetails().getBranch());
    			}
    			bankAccountRepository.save(bankAccountDetailsToUpdate);
    		}
	    	employeeRepository.save(employeeToUpdate);
	    	employeeUpdated = true;
    	}
    	return employeeUpdated;
    }
}
