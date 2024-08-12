package com.crud.DTO;

import java.util.Date;

public class CustomerDTO {
	
	private int customerid;
	private String customerName;
	private String mobileNumber;
	private Date customerDOB;
	private String customerEmail;
	private byte customerAge;
	private double totalSpent;
	private boolean memebershipStatus;
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
