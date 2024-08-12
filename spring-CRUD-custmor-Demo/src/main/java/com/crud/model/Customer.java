package com.crud.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	private String customerName;
	@Column(length = 10)
	private String mobileNumber;
	@Temporal(TemporalType.DATE)
	private Date customerDOB;
	private String customerEmail;
	private byte customerAge;
	private double totalSpent;
	private boolean memebershipStatus;
	/*
	 *  generate getters and setters
	 */
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public byte getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(byte customerAge) {
		this.customerAge = customerAge;
	}
	public double getTotalSpent() {
		return totalSpent;
	}
	public void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
	}
	public boolean isMemebershipStatus() {
		return memebershipStatus;
	}
	public void setMemebershipStatus(boolean memebershipStatus) {
		this.memebershipStatus = memebershipStatus;
	}
	
	
	
	
	
}
