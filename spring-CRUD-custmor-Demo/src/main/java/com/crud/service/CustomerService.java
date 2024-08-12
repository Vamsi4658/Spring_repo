package com.crud.service;

import java.util.List;

import com.crud.DTO.CustomerDTO;
import com.crud.model.Customer;

public interface CustomerService {
	/*
	 *  insertion 
	 */
	int addCustmorDetails(CustomerDTO custmorDTO);
	List<Integer>  addBulkCustomerDetails(List<CustomerDTO> customerDTOs);
	/*
	 *  fetching
	 */
	List<CustomerDTO> fetchAllCustomers();
	CustomerDTO fetchCustomerById(int id);
	/*
	 *  update
	 */
	CustomerDTO updateCutomerNameByCustomerId(int id, String newCustomerName);
	CustomerDTO updateCutomerDetailsById(int id, CustomerDTO customer);
	/*
	 *  delete
	 */
	String deleteCustomerById(int id);
	String deleteAllCustomer();
	
}
