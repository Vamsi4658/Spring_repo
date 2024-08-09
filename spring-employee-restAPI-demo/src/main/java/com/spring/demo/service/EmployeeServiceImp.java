package com.spring.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.spring.demo.model.Employee;

/*
 * This class implements the EmployeeService interface, providing
 * the logic for managing Employee data. Since there is no database 
 * connection, the data is stored in a List.
 */
public class EmployeeServiceImp implements EmploypeeService{
	
	// List to store Employee objects
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	/*
     * Adds a single Employee using a POST request.
     * 
     * @RequestBody employee The Employee object to be added (provided in the request body).
     * return A String message indicating the index at which the employee was added.
     */
	@Override
	public String addEmployee(Employee employee) {
		
		employeeList.add(employee);
		return "Employee added list at the index of: "+employeeList.indexOf(employee);
	}
	/*
     * Adds a list of Employees to the employeeList.
     * 
     * @param employees The list of Employee objects to be added.
     * @return The updated list of all Employee objects.
     */
	@Override
	public List<Employee> addListOFEmployees(List<Employee> employees) {
		employeeList.addAll(employees);
		return employeeList;
	}
   /*
    * Returns a list of all Employees stored in the employeeList.
    * 
    * @return The list of all Employee objects.
    */
	@Override
	public List<Employee> displayAllEmployees() {
		return employeeList;
	}
	/*
     * Searches for an Employee by their ID and returns the corresponding Employee object.
     * 
     * @param id The ID of the Employee to be searched.
     * @return The Employee object if found, or null if not found.
     */
	@Override
	public Employee showEmployee(int id) {
		
		for (Employee employee : employeeList) {
			
			if (employee.getEmp_id()==id) {
				return employee;
			}
		}
		return null;
	}
	/*
     * Updates an existing Employee's data by their ID.
     * 
     * @param id The ID of the Employee to be updated.
     * @param emp The Employee object containing the updated data.
     * @return The original Employee object if the update was successful, or null if not.
     */
	@Override
	public Employee updateEmployee(int id,double sal) {
		//Employee emp = new Employee();
		for (Employee employee : employeeList) {
			if (employee.getEmp_id()==id) {
				employee.setSalary(sal);
				employeeList.add(employee); // This should ideally update the employee in place
				return employee;
			}
		}
		return null;
	}
	/*
     * Deletes an Employee from the employeeList by their ID.
     * 
     * @param id The ID of the Employee to be deleted.
     * @return true if the Employee was successfully deleted, false if no Employee with the given ID was found.
     */
	@Override
	public boolean deleteEmployee(int id) {
		
		Iterator<Employee> iterator = employeeList.iterator();
	    while (iterator.hasNext()) {
	        Employee employee = iterator.next();
	        if (employee.getEmp_id() == id) {
	            iterator.remove();
	            return true; // Indicate that the employee was successfully deleted
	        }
	    }
	    return false; // Indicate that no employee with the given ID was found
	}

	
}
