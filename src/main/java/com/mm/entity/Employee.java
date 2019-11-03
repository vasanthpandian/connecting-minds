package com.mm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private int empId;
	
	@OneToOne
	@JoinColumn(name = "COMPANY_ID")
	Company company;
	
	@OneToOne
	@JoinColumn(name = "BANK_ID")
	BankAccountDetails bankAccountDetails;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private int age;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_JOINING")
	private Date doj;
	
	@Column(name = "SALARY")
	private float salary;
	
	@Column(name = "SURCHARGE")
	private float surcharge;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobile;
	
	@Column(name = "EMAIL")
	private String email;
	
}
