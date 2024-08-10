package com.crud.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.model.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	/*
     * Converts ProductDTO to Product and saves it to the database.
     * @param productDto The data transfer object containing the product details to be saved.
     * @return The saved Product entity.
     */
	@Override
	public Product createProduct(ProductDTO productDto) {	
		Product product = new Product();
//		product.setProductId(productDto.getProductId());  //auto increment
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());		
		product.setQuantity(productDto.getQuantity());
		product.setDate(productDto.getDate());
		
		 return productRepository.save(product);
	}
	/*
     * Retrieves all products from the database and converts them into a response DTO.
     * @return A ResponceProductDTO containing a list of all ProductDTOs and the total number of products.
     */
	@Override
	public ResponceProductDTO showAllProduct() {
		ResponceProductDTO responceProductDTO = new ResponceProductDTO();
		List<ProductDTO> productDTOs= new ArrayList<ProductDTO>();	
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDate(product.getDate());
			productDTO.setQuantity(product.getQuantity());
			
			productDTOs.add(productDTO); // add 
		}
		responceProductDTO.setProductDTOs(productDTOs);
		responceProductDTO.setTotalProducts(productRepository.count());
		return responceProductDTO;
	}
	/*
     * Retrieves a specific product by its ID and converts it into a ProductDTO.
     * @param productId The ID of the product to retrieve.
     * @return A ProductDTO containing the product details, or null if the product is not found.
     */
	@Override
	public ProductDTO showProduct(Integer productId) {
		ProductDTO productDTO = new ProductDTO();
		Product product =productRepository.findById(productId).orElse(null);
		if (product!=null) {
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDate(product.getDate());
			productDTO.setQuantity(product.getQuantity());
		}
		return productDTO;
	}
	/*
     * Updates the name of a specific product by its ID.
     * @param id The ID of the product to update.
     * @param productName The new name to assign to the product.
     * @return The updated ProductDTO containing the new product details.
     */
	@Override
	public ProductDTO updateProductName(int id, String productName) {
		ProductDTO productDTO = new ProductDTO();
		Product product =productRepository.findById(id).orElse(null);
		if (product!=null) {
			product.setProductName(productName);
			productRepository.save(product); // Save the updated product

			// Populate the DTO with updated product details
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDate(product.getDate());
			productDTO.setQuantity(product.getQuantity());
		}
		return productDTO;
	}
	/*
     * Deletes a specific product by its ID.
     * @param id The ID of the product to delete.
     */
	@Override
	public void  deleteProductByIdh(int id) {
		Product product =productRepository.findById(id).orElse(null);
		if (product!=null) {			
			productRepository.deleteById(id);
		}
	}

}
