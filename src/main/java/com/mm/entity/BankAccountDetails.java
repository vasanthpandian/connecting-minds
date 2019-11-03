package com.mm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BANK_ACCOUNT_DETAILS")
public class BankAccountDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    private long bankId;
	
	@JoinColumn(name = "EMP_ID", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "BANK")
	private String bank;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "IFSC")
	private String ifsc;
}