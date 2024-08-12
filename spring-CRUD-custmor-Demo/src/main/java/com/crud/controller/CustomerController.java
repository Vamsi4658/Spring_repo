package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.DTO.CustomerDTO;
import com.crud.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	/*
	 *  Postmapping operations
	 */
	/**
	 * Endpoint to add a single customer's details.
	 * 
	 * @RequestBody custmorDTO The customer details to be added.
	 * @return ResponseEntity with a success message and the customer ID, and a status of CREATED.
	 */
	@PostMapping("customer/add")
	public ResponseEntity<String> addCustmorDetails(@RequestBody CustomerDTO custmorDTO){
		 int custmorDetails = customerService.addCustmorDetails(custmorDTO);
		return new ResponseEntity<>("customer details saved successfully customer id is:"+custmorDetails,HttpStatus.CREATED);
	}
	/**
	 * Endpoint to add multiple customers' details in bulk.
	 * 
	 * @RequestBody customerDTOs A list of customer details to be added.
	 * @return ResponseEntity with a success message and a list of customer IDs, and a status of CREATED.
	 */
	@PostMapping("customer/add/bulk")
	public ResponseEntity<String> addMultipleCustomer(@RequestBody List<CustomerDTO> customerDTOs){
		List<Integer> customerIds = customerService.addBulkCustomerDetails(customerDTOs);
		return new ResponseEntity<>("Customer details added successfully their ids are: "+customerIds,HttpStatus.CREATED);
	}
	/*
	 *  Getmapping operations
	 *  	
	 * Endpoint to fetch all customer details.
	 * 
	 * @return ResponseEntity with a list of all customer details and a status of OK.
	 */
	@GetMapping("customer/get/all")
	public ResponseEntity<List<CustomerDTO>> fetchAllCustomers(){
		List<CustomerDTO> allCustomers = customerService.fetchAllCustomers();
		return new ResponseEntity<>(allCustomers,HttpStatus.OK);
	}
	/*
	 * Endpoint to fetch customer details by ID. 
	 * @RequestBody id The ID of the customer to be fetched.
	 * @return ResponseEntity with the customer details and a status of OK.
	 *  
	 */
	@GetMapping("customer/getbyid/{id}")
	public ResponseEntity<CustomerDTO> fetchCustomerById(@PathVariable int id){
		CustomerDTO customer = customerService.fetchCustomerById(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	/*
	 *   >>>>>>> Putmapping operations 
	 *   
	 *   
	 * @Pathvariable id The ID of the customer to be updated.
	 * @RequestBody newCustomerName The new name for the customer.
	 * @return ResponseEntity with the updated customer details and a status of OK.
	 * 
	 */
	@PutMapping("customer/update/{id}/customername")
	public ResponseEntity<CustomerDTO> updateCustomerNameById(@PathVariable int id, String newCustomerName){
		CustomerDTO updatedCustomerDetails = customerService.updateCutomerNameByCustomerId(id,newCustomerName);
		return new ResponseEntity<>(updatedCustomerDetails,HttpStatus.OK);
	}
	/**
	 * Endpoint to update all details of a customer by their ID.
	 * 
	 * @Pathvariable id The ID of the customer to be updated.
	 * @RequestBody customerDTO The new customer details.
	 * @return ResponseEntity with the updated customer details and a status of OK.
	 */
	@PutMapping("customer/update/{id}/all")
	public ResponseEntity<CustomerDTO> updateCustDetails(@PathVariable int id, @RequestBody CustomerDTO customerDTO){
		CustomerDTO cDTO = customerService.updateCutomerDetailsById(id, customerDTO);
		return new ResponseEntity<>(cDTO,HttpStatus.OK);
	}
	/**
	 * Endpoint to delete a customer by their ID.
	 * 
	 * @Pathvariable id The ID of the customer to be deleted.
	 * @return ResponseEntity with a status message and a status of OK.
	 */
	@DeleteMapping("customer/delete/customer/{id}")
	public ResponseEntity<String> removeCutomerById(@PathVariable int id){
		String status = customerService.deleteCustomerById(id);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	/*
	 *   Endpoint to delete a customer from the database customer table
	 */
	@DeleteMapping("customer/delete/customer/all")
	public ResponseEntity<String> removeAllCustmors(@PathVariable int id){
		String status = customerService.deleteAllCustomer();
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
