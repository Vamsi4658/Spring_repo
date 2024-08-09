package com.crud.service;

import java.util.List;

import com.crud.model.Product;

public interface ProductService {

	Product createProduct(Product product);

	List<Product> showAllProduct();

	Product showProduct(Integer productId);

	Product updateProduct(Integer productId, String name);

	Product removeProduct(int id);

}
