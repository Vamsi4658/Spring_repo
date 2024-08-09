package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.model.Product;
import com.crud.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	/*
	 *  --->> insertion value into database
	 */
	@PostMapping("/create/product")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		productService.createProduct(productDTO);
		return new ResponseEntity<>("Product added sucessfully",HttpStatus.CREATED);
	}
	
	/*
	 *   --->> fetch all data
	 */
	@GetMapping("/fetch/product")
	public ResponseEntity<ResponceProductDTO> getAllProduct(){
		ResponceProductDTO responceProductDTO = productService.showAllProduct();
		return new ResponseEntity<>(responceProductDTO,HttpStatus.OK);
	}
	/*
	 *   --->> update name of the item
	 */
	@GetMapping("/fetch/product/{productId}/name")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId){
		ProductDTO productDTO = productService.showProduct(productId);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
}
