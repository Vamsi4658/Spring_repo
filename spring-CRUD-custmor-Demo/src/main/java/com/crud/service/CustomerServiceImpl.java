package com.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.DTO.CustomerDTO;
import com.crud.model.Customer;
import com.crud.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	/**
	 * Adds a single customer's details to the database.
	 * 
	 *  custmorDTO The customer details to be added.
	 *  return The ID of the saved customer.
	 */
	@Override
	public int addCustmorDetails(CustomerDTO custmorDTO) {
		Customer customer = new  Customer(); // customer entity Object created 
		customer.setCustomerName(custmorDTO.getCustomerName());
		customer.setMobileNumber(custmorDTO.getMobileNumber());
		customer.setCustomerDOB(custmorDTO.getCustomerDOB());
		customer.setCustomerEmail(custmorDTO.getCustomerEmail());
		customer.setCustomerAge(custmorDTO.getCustomerAge());
		customer.setTotalSpent(custmorDTO.getTotalSpent());
		customer.setMemebershipStatus(custmorDTO.isMemebershipStatus());
		// saving into database
		Customer savedCustomerDetails = customerRepository.save(customer);
		
		return customer.getCustomerid();
	}
	/**
	 * Adds multiple customers' details to the database in bulk.
	 * 
	 * customerDTOs A list of customer details to be added.
	 * @return A list of IDs of the saved customers.
	 */
	@Override
	public List<Integer> addBulkCustomerDetails(List<CustomerDTO> customerDTOs) {
		List<Customer> customers = new ArrayList<Customer>();
		
		List<Integer> customerIds = new ArrayList<Integer>();
		
		for (CustomerDTO customerDTO : customerDTOs) {
			Customer customer = new Customer();
			customer.setCustomerName(customerDTO.getCustomerName());
			customer.setMobileNumber(customerDTO.getMobileNumber());
			customer.setCustomerDOB(customerDTO.getCustomerDOB());
			customer.setCustomerEmail(customerDTO.getCustomerEmail());
			customer.setCustomerAge(customerDTO.getCustomerAge());
			customer.setTotalSpent(customerDTO.getTotalSpent());
			customer.setMemebershipStatus(customerDTO.isMemebershipStatus());
			
			customerRepository.save(customer);
			
			customers.add(customer);
			customerIds.add(customer.getCustomerid());
		}
		return customerIds;
	}
	/**
	 * Fetches all customers' details from the database.
	 * 
	 * @return A list of all customer details as CustomerDTO objects.
	 */
	@Override
	public List<CustomerDTO> fetchAllCustomers() {
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		List<Customer> customers = customerRepository.findAll();
		
		for (Customer customer : customers) {
			
			CustomerDTO customerDTO = new CustomerDTO();
			
			customerDTO.setCustomerid(customer.getCustomerid());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setCustomerDOB(customer.getCustomerDOB());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAge(customer.getCustomerAge());
			customerDTO.setTotalSpent(customer.getTotalSpent());
			customerDTO.setMemebershipStatus(customer.isMemebershipStatus());
			
			customerDTOs.add(customerDTO);
		}
		return customerDTOs;
	}
	/**
	 * Fetches a customer's details by their ID.
	 * 
	 * id The ID of the customer to be fetched.
	 * @return The customer's details as a CustomerDTO object.
	 */
	@Override
	public CustomerDTO fetchCustomerById(int id) {
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		Customer customer = customerRepository.findById(id).orElse(null);
		
		customerDTO.setCustomerid(customer.getCustomerid());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setMobileNumber(customer.getMobileNumber());
		customerDTO.setCustomerDOB(customer.getCustomerDOB());
		customerDTO.setCustomerEmail(customer.getCustomerEmail());
		customerDTO.setCustomerAge(customer.getCustomerAge());
		customerDTO.setTotalSpent(customer.getTotalSpent());
		customerDTO.setMemebershipStatus(customer.isMemebershipStatus());
		
		return customerDTO;
	}
	
	
	/**
	 * Updates a customer's name by their ID.
	 * 
	 *  id The ID of the customer to be updated.
	 *  newCustomerName The new name for the customer.
	 * @return The updated customer details as a CustomerDTO object.
	 */
	@Override
	public CustomerDTO updateCutomerNameByCustomerId(int id, String newCustomerName) {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer!=null) {
			customer.setCustomerName(newCustomerName);
			customerRepository.save(customer);
			
			customerDTO.setCustomerid(customer.getCustomerid());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setCustomerDOB(customer.getCustomerDOB());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAge(customer.getCustomerAge());
			customerDTO.setTotalSpent(customer.getTotalSpent());
			customerDTO.setMemebershipStatus(customer.isMemebershipStatus());
			
			return customerDTO;
		}
		return null;
	}
	/**
	 * Updates a customer's name by their ID.
	 * 
	 *  id The ID of the customer to be updated.
	 *  newCustomerName The new name for the customer.
	 * 	@return The updated customer details as a CustomerDTO object.
	 */
	@Override
	public CustomerDTO updateCutomerDetailsById(int id, CustomerDTO customerDTO) {
		CustomerDTO custDTO = new CustomerDTO();
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer!=null) {
			customer.setCustomerName(customerDTO.getCustomerName());
			customer.setMobileNumber(customerDTO.getMobileNumber());
			customer.setCustomerDOB(customerDTO.getCustomerDOB());
			customer.setCustomerEmail(customerDTO.getCustomerEmail());
			customer.setCustomerAge(customerDTO.getCustomerAge());
			customer.setTotalSpent(customerDTO.getTotalSpent());
			customer.setMemebershipStatus(customerDTO.isMemebershipStatus());
			
			customerRepository.save(customer);
			
			customerDTO.setCustomerid(customer.getCustomerid());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setCustomerDOB(customer.getCustomerDOB());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAge(customer.getCustomerAge());
			customerDTO.setTotalSpent(customer.getTotalSpent());
			customerDTO.setMemebershipStatus(customer.isMemebershipStatus());
			
			return customerDTO;
		}
		return null;		
	}
	/**
	 * Deletes a customer's details by their ID.
	 * 
	 *  id The ID of the customer to be deleted.
	 * @return A message indicating whether the deletion was successful or not.
	 */
	@Override
	public String deleteCustomerById(int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer!=null) {
			int c_id = customer.getCustomerid();
			customerRepository.deleteById(id);
			return "Customer bearing id: "+c_id+" details removed successfully from database";
		}
		return "Customer bearing id: "+id+" not founded....";
	}

	/**
	 * Deletes all customer records from the database.
	 * 
	 * @return A message indicating that all data has been wiped from the Customer table.
	 */
	@Override
	public String deleteAllCustomer() {
		customerRepository.deleteAll();
		return "data successfully wiped out from Database Customer table";
	}
	
}
