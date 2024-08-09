package com.spring.demo.service;

import java.util.List;

import com.spring.demo.model.Employee;

public interface EmploypeeService {
	
	public String addEmployee(Employee employee);
	public List<Employee> addListOFEmployees(List<Employee> employees);
	
	public Employee showEmployee(int id);
	public  List<Employee> displayAllEmployees();
	public Employee updateEmployee(int id, double sal);
	public boolean deleteEmployee(int id);
	
}
