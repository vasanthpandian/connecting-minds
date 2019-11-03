package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmpId(int empId);
}
