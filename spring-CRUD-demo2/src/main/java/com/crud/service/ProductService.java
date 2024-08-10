package com.crud.service;

import java.util.List;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.model.Product;

public interface ProductService {

	/*
     * Creates a new product in the database.
     * @param productDTO The data transfer object containing the details of the product to be created.
     * @return The created Product entity.
     */
	Product createProduct(ProductDTO productDTO);
	 /*
     * Retrieves all products from the database.
     * @return A ResponceProductDTO containing a list of all ProductDTOs and the total number of products.
     */
	ResponceProductDTO showAllProduct();
	/*
     * Retrieves a specific product by its ID.
     * @param productId The ID of the product to retrieve.
     * @return A ProductDTO containing the product details, or null if the product is not found.
     */
	ProductDTO showProduct(Integer productId);
	/*
     * Updates the name of a specific product by its ID.
     * @param id The ID of the product to update.
     * @param productName The new name to assign to the product.
     * @return The updated ProductDTO containing the new product details.
     */
	ProductDTO updateProductName(int id, String productName);
	/*
     * Deletes a specific product by its ID.
     * @param id The ID of the product to delete.
     */
	void deleteProductByIdh(int id);

}
