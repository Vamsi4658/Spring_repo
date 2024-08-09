package com.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stud_id;
	@Column(name = "studentName")
	private String stud_Name;
	private String collegeName;
	private double cgpa;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name="home_street")),
		@AttributeOverride(name = "city", column = @Column(name="home_city")),
		@AttributeOverride(name = "state", column = @Column(name="home_state")),
		@AttributeOverride(name = "pincode", column = @Column(name="home_pincode"))
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name="office_street")),
		@AttributeOverride(name = "city", column = @Column(name="office_city")),
		@AttributeOverride(name = "state", column = @Column(name="office_state")),
		@AttributeOverride(name = "pincode", column = @Column(name="office_pincode"))
	})
	private Address officeAddress;
	
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getStud_Name() {
		return stud_Name;
	}
	public void setStud_Name(String stud_Name) {
		this.stud_Name = stud_Name;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
}
