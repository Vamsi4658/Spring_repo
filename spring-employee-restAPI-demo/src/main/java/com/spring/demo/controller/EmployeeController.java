package com.spring.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.Employee;
import com.spring.demo.service.EmployeeServiceImp;
import com.spring.demo.service.EmploypeeService;


@RestController
public class EmployeeController {
	
	// Instance of EmployeeService to handle business logic
	private EmploypeeService emp = new EmployeeServiceImp();
	/*
     * Adds a single Employee using a POST request.
     * 
     * @param employee The Employee object to be added (provided in the request body).
     * @return A String message indicating the index at which the employee was added.
     */
	@PostMapping("/add/emp")
	public String addEmployee(@RequestBody Employee employee) {
		
		return emp.addEmployee(employee);
	}
	/*
     * Adds a list of Employees using a POST request.
     * 
     * @param employees A list of Employee objects to be added (provided in the request body).
     * @return The updated list of all Employee objects.
     */
	@PostMapping("/add/emp/list")
	public List<Employee> addListOfEmployees(@RequestBody List<Employee> employees) {
		
		return emp.addListOFEmployees(employees);
	}
	/*
     * Displays all Employees using a GET request.
     * 
     * @return A list of all Employee objects.
     */
	@GetMapping("/show/allemps")
	public List<Employee> displayAllEmployee(){
		return emp.displayAllEmployees();
	}
	/*
     * Shows a specific Employee by their ID using a GET request.
     * 
     * @param id The ID of the Employee to be retrieved (provided in the URL path).
     * @return The Employee object if found, or null if not found.
     */
	@GetMapping("/show/{id}")
	public Employee showEmployee(@PathVariable int id) {
		return emp.showEmployee(id);
	}
	/*
     * Updates the salary of an Employee by their ID using a PUT request.
     * 
     * @param id The ID of the Employee to be updated (provided in the URL path).
     * @param employee The Employee object containing the updated salary (provided in the request body).
     * @return The original Employee object if the update was successful, or null if not.
     */
	@PutMapping("/update/emp/{id}/sal")
	public Employee updateEmpSal(@PathVariable int id, @RequestBody double sal) {
		return emp.updateEmployee(id, sal);
	}
	/*
     * Deletes an Employee by their ID using a DELETE request.
     * 
     * @param id The ID of the Employee to be deleted (provided in the URL path).
     * @return true if the Employee was successfully deleted, false if no Employee with the given ID was found.
     */
	@DeleteMapping("/del/emp/{id}")
	public boolean deleteEmployee(@PathVariable int id) {
		return emp.deleteEmployee(id);
	}
} 
