package com.mm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mm.entity.Employee;

@Service
public interface EmployeeService  {
	
	public Employee getEmployee(final int empId);
	
	public List<Employee> getAllEmployees();
	
    public boolean addEmployee(final Employee employee);
    
    public boolean deleteEmployee(final Employee employee);
    
    public boolean updateEmployee(final Employee employee);
}
