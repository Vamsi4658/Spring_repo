package com.example.pack.model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "employee")
public class EmployeeModel {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;
	private String emp_name;
	private double emp_salary;
//	@Autowired
//	private DepartmentModel department; 	
//	
	public EmployeeModel() {
		// TODO Auto-generated constructor stub
	}
	
//	public EmployeeModel(int emp_id, String emp_name, double emp_salary, DepartmentModel department) {
//		super();
//		this.emp_id = emp_id;
//		this.emp_name = emp_name;
//		this.emp_salary = emp_salary;
////		this.department = department;
//	}



//	public void setDepartment(DepartmentModel departmentModel) {
//		this.department =departmentModel;
//	}
//	public DepartmentModel getDepartment() {
//		return department;
//	}
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
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}

}
