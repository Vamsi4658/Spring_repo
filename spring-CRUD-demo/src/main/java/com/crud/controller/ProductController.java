package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.model.Product;
import com.crud.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	/*
	 *  --->> insertion value into database
	 */
	@PostMapping("/create/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product2 =productService.createProduct(product);
		return new ResponseEntity<>(product2,HttpStatus.CREATED);
	}
	/*
	 *   --->> fetch all data
	 */
	@GetMapping("/fetch/product")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> showAllProduct = productService.showAllProduct();
		return new ResponseEntity<>(showAllProduct,HttpStatus.OK);
	}
	/*
	 *   --->> fetching specified recorded data
	 */
	@GetMapping("/fetch/product/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
		Product product = productService.showProduct(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	/*
	 *   --->> update by id update product name
	 */
	@PutMapping("/update/{productId}/productname")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody String name){
		Product product1 = productService.updateProduct(productId, name);
		return new ResponseEntity<>(product1,HttpStatus.OK);
	}
	/*
	 *  ---->> delete product by id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable int id){
		Product product = productService.removeProduct(id);
		if (product!=null) {
			return new ResponseEntity<>("product deleted from database",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("product not found in database",HttpStatus.NO_CONTENT);
		}
	}
}
