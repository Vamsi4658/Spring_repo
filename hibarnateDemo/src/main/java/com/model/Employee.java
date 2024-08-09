package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_Id;
	@Column(length = 20)
	private String emp_Name;
	@Temporal( TemporalType.DATE)
	private Date date_Of_Join;
	@Column(length = 10)
	private String emp_mobile_num;
	@Column(length = 10,precision = 2)
	private double salary;
	
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public Date getDate_Of_Join() {
		return date_Of_Join;
	}
	public void setDate_Of_Join(Date date_Of_Join) {
		this.date_Of_Join = date_Of_Join;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmp_mobile_num() {
		return emp_mobile_num;
	}
	public void setEmp_mobile_num(String emp_mobile_num) {
		this.emp_mobile_num = emp_mobile_num;
	}
}
