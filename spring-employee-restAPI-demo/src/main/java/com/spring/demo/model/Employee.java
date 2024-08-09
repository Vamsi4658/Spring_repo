package com.spring.demo.model;

import java.io.Serializable;
/*
 *  model class
 */
public class Employee implements Serializable{

	private int emp_id;
	private String emp_name;
	private String Emp_roll;
	private Double salary;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_roll() {
		return Emp_roll;
	}
	public void setEmp_roll(String emp_roll) {
		Emp_roll = emp_roll;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
}
