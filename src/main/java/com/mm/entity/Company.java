package com.mm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	String companyId;
	
	@Column(name = "COMPANY_NAME")
	String name;
	
	@Column(name = "BLOCK")
	String block;
	
	@Column(name = "TYPE")
	String type;
	
	@Column(name = "IS_ACTIVE")
	boolean isActive;
	
	@Column(name = "ENROLLED")
	boolean enrolled;
	
	@OneToMany(cascade= CascadeType.ALL)
    @JoinColumn
    private List<Employee> employees;
	
}