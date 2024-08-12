package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ProductController {

	// Instance of EmployeeService to handle business logic
	@Autowired
	private ProductService productService;
	/*
     * End point to create a new product.
     * @param productDTO The data transfer object containing the details of the product to be created.
     * @return A response entity containing a success message and HTTP status code 201 (CREATED).
     */
	@PostMapping("/create/product")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		productService.createProduct(productDTO);
		return new ResponseEntity<>("Product added sucessfully",HttpStatus.CREATED);
	}
	
	/*
     * End point to fetch all products.
     * @return A response entity containing a list of all products and HTTP status code 200 (OK).
     */
	@GetMapping("/fetch/product")
	public ResponseEntity<ResponceProductDTO> getAllProduct(){
		ResponceProductDTO responceProductDTO = productService.showAllProduct();
		return new ResponseEntity<>(responceProductDTO,HttpStatus.OK);
	}
	/*
     * End point to fetch a particular product by its ID.
     * @param productId The ID of the product to be retrieved.
     * @return A response entity containing the product details and HTTP status code 200 (OK).
     */
	@GetMapping("/fetch/product/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId){
		ProductDTO productDTO = productService.showProduct(productId);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	/*
     * End point to update the name of a product by its ID.
     * @PathVariable id The ID of the product to be updated.
     * @R productName The new name of the product.
     * @return A response entity containing the updated product details and HTTP status code 201 (CREATED).
     */
	@PutMapping("/update/product/{id}/productname")
	public ResponseEntity<ProductDTO> updateProductNameById(@PathVariable int id, @RequestBody String productName){
		ProductDTO productDTO = productService.updateProductName(id,productName);
		return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
	}
	/*
     * End point to delete a product by its ID.
     * @param id The ID of the product to be deleted.
     * @return A response entity containing a success message and HTTP status code 201 (CREATED).
     */
	@DeleteMapping("/delete/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id){
		String status = productService.deleteProductByIdh(id);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
