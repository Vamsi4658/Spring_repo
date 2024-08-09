package com.spring.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.Employee;

@RestController
public class EmployeeController {

	
	@PostMapping(value = "/displayEmp")
	public Employee dusplayEmployee(@RequestBody Employee employee) {
		
		employee.setEmp_name("mr/miss: "+employee.getEmp_name());
		return employee;
	}
}
