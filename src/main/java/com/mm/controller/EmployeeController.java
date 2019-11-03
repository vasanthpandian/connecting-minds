package com.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.entity.Employee;
import com.mm.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable final int empId) {
		return employeeService.getEmployee(empId);
    }
	
	@GetMapping("/all")
    public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
    }
	
	@PostMapping("/add")
    public boolean addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
    }
	
	@PostMapping("/update")
    public boolean updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
    }
}
